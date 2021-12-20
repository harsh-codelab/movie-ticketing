package com.example.movieticketing.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_session")
public class UserSession {

    @Id
    @Column(name = "id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("session_id")
    Long id;

    @JsonProperty("user_id")
    @Column(name = "user_id")
    Long userId;

    @JsonProperty("is_active")
    @Column(name = "is_active")
    Boolean isActive;

    @JsonProperty("last_login")
    @Column(name = "last_login")
    LocalDateTime lastLoggedIn;

    public UserSession(Long userId) {
        this.userId = userId;
        this.isActive = true;
        this.lastLoggedIn = LocalDateTime.now();
    }
}
