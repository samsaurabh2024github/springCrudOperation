package com.sauv.learn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "App")
public class User {
    @Id
    @Column(name = "user_id")
    private String Id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_password")
    private String password;

}
