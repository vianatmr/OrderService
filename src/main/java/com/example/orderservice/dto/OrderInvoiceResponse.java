package com.example.orderservice.dto;

import com.example.orderservice.entity.Film;
import com.example.orderservice.entity.Schedule;
import com.example.orderservice.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class OrderInvoiceResponse {
    private String username;
    private String email;
    private String filmName;
    private LocalDate tanggal_tayang;
    private LocalTime jam_mulai;
    private LocalTime jam_selesai;

    public static OrderInvoiceResponse build(Schedule schedule, User user, Film film) {
        return OrderInvoiceResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .filmName(film.getFilm_name())
                .tanggal_tayang(schedule.getTanggal_tayang())
                .jam_mulai(schedule.getJam_mulai())
                .jam_selesai(schedule.getJam_selesai())
                .build();
    }
}
