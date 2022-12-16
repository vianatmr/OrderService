package com.example.orderservice.service.impl;

import com.example.orderservice.dto.OrderInvoiceResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.entity.Film;
import com.example.orderservice.entity.Orders;
import com.example.orderservice.entity.Schedule;
import com.example.orderservice.entity.User;
import com.example.orderservice.repository.FilmRepository;
import com.example.orderservice.repository.OrdersRepository;
import com.example.orderservice.repository.ScheduleRepository;
import com.example.orderservice.repository.UserRepository;
import com.example.orderservice.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;


    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) {
        try {
            Optional<Film> film = filmRepository.findById(orderRequest.getFilm_code());
            if (film.isPresent()) {
                Optional<User> user = userRepository.findById(orderRequest.getUser_id());
                if (user.isPresent()) {
                    Orders orders = orderRequest.toOrder();
                    try {
                        ordersRepository.save(orders);
                        return OrderResponse.build(orders);
                    } catch (Exception exception) {
                        return null;
                    }
                }
            } else
                return null;
        } catch (Exception exception) {
            return null;
        }
        return null;
    }


    @Override
    public List<OrderInvoiceResponse> getDetailOrder(String username, String film_name) {
        List<Orders> allOrders = ordersRepository.getDetailOrder(username, film_name);
        List<User> allUser = userRepository.getUserOrder(username, film_name);
        List<Film> allFilm = filmRepository.getFilmOrder(username, film_name);
        List<Schedule> allSchedule = scheduleRepository.getScheduleOrder(username, film_name);
        List<OrderInvoiceResponse> detailorder = new ArrayList<>();
        for (Orders orders : allOrders)
        {
            for (User user : allUser)
            {
                for (Film film : allFilm)
                {
                    for (Schedule schedule : allSchedule)
                    {
                    OrderInvoiceResponse allOrderResponse = OrderInvoiceResponse.build(schedule, user, film);
                    detailorder.add(allOrderResponse);
                    break;
                    }
                    break;
                }
                break;
            }

        }
        return detailorder;
    }
}
