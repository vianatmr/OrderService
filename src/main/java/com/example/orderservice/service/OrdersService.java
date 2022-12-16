package com.example.orderservice.service;

import com.example.orderservice.dto.OrderInvoiceResponse;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.dto.OrderResponse;

import java.util.List;


public interface OrdersService {
    OrderResponse addOrder(OrderRequest orderRequest);
    List<OrderInvoiceResponse> getDetailOrder(String username, String film_name);
}
