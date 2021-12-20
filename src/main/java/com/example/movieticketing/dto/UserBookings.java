package com.example.movieticketing.dto;

import com.example.movieticketing.entity.Shows;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class UserBookings {

    @JsonProperty("user_id")
    Long userId;

    @JsonProperty("booked_shows")
    List<Shows> bookedShows ;

}
