package com.learning.springsecurityregistration.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String userName;
    private String email;
    @Column(length = 60)
    private String password;
    private String role;
    private boolean enabled=false;
}
