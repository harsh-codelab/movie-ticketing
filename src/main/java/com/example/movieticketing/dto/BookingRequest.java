package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BookingRequest {

    @JsonProperty("show_id")
    Long showId;

    @JsonProperty("user_id")
    Long userId;

    @JsonProperty("required_seats")
    Integer requiredSeats;

    @JsonProperty("session_id")
    Long sessionId;

}
