package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SignUpRequest {

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("user_email")
    String userEmail;

    @JsonProperty("user_mobile")
    String userMobile;

    @JsonProperty("user_password")
    String password;

}
