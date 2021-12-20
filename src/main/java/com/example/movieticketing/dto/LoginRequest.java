package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class LoginRequest {

    @JsonProperty("user_email")
    String userEmail;

    @JsonProperty("user_password")
    String password;

}
