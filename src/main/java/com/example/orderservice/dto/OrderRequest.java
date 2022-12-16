package com.example.orderservice.dto;

import com.example.orderservice.entity.Orders;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OrderRequest {
    @NotEmpty(message = "Seat Number is required.")
    private String seatNum;
    @NotEmpty(message = "Strudio id is required.")
    private Integer studio_id;
    @NotEmpty(message = "Total Ticket is required.")
    private Integer jumlah;
    @NotEmpty(message = "Film code is required.")
    private Integer film_code;
    @NotEmpty(message = "User id is required.")
    private Long user_id;

    public Orders toOrder() {
        Orders orders = new Orders();
        orders.setSeatNum(this.seatNum);
        orders.setStudio_id(this.studio_id);
        orders.setJumlah(this.jumlah);
        orders.setFilm_code(this.film_code);
        orders.setUser_id(this.user_id);
        return orders;
    }
}
