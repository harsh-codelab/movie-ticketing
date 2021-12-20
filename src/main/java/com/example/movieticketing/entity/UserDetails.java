package com.example.movieticketing.entity;

import com.example.movieticketing.dto.SignUpRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserDetails {

    @Id
    @Column(name = "id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonProperty("user_name")
    @Column(name = "user_name")
    String userName;

    @JsonProperty("user_email")
    @Column(name = "user_email")
    String userEmail;

    @JsonProperty("user_mobile")
    @Column(name = "user_mobile")
    String userMobile;

    @JsonIgnore
    @Column(name = "user_password")
    String password;

    public UserDetails(SignUpRequest request) {
        this.userName = request.getUserName();
        this.userEmail = request.getUserEmail();
        this.userMobile = request.getUserMobile();
    }
}
