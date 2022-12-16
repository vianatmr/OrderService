package com.example.orderservice.dto;

import com.example.orderservice.entity.Orders;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OrderResponse {
    private Integer order_id;
    private String seatNum;
    private Integer studio_id;
    private Integer jumlah;
    private Integer film_code;
    private Long user_id;

    public static OrderResponse build(Orders orders) {
        return OrderResponse.builder()
                .order_id(orders.getOrder_id())
                .seatNum(orders.getSeatNum())
                .studio_id(orders.getStudio_id())
                .jumlah(orders.getJumlah())
                .film_code(orders.getFilm_code())
                .user_id(orders.getUser_id())
                .build();
    }
}
