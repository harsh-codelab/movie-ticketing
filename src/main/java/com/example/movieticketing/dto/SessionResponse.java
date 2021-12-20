package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class SessionResponse {

    @JsonProperty("session_id")
    Long id;

    @JsonProperty("valid_till")
    LocalDateTime validTill;
}
