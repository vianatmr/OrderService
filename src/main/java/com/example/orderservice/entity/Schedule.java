package com.example.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer schedule_id;

    @Column
    private Integer film_code;
    @ManyToOne
    @JoinColumn(name = "film_code", nullable = false, insertable = false, updatable = false)
    private Film film;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column
    private LocalDate tanggal_tayang;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column
    private LocalTime jam_mulai;

    @JsonFormat(pattern = "HH:mm:ss")
    @Column
    private LocalTime jam_selesai;
}
