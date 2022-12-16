package com.example.orderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    private Integer SeatNum;
    @Id
    private Integer studio_id;
    @Column
    private boolean seat_status;
    @Column
    private String SeatRow;

}
