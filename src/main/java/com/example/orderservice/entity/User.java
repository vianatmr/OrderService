package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email"),
        }, schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String username;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 200, nullable = false)
    private String password;

    @OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
    private List<Orders> orders;

}
