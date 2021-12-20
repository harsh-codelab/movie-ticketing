package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateShow {

    @JsonProperty("movie_name")
    String movieName;

    @JsonProperty("cinema_name")
    String cinemaName;

    @JsonProperty("available_from")
    LocalDateTime availableFrom;

    @JsonProperty("available_till")
    LocalDateTime availableTill;

    @JsonProperty("movie_price")
    Integer price;

    @JsonProperty("total_seats")
    Integer totalSeats;

    @JsonProperty("city_name")
    String cityName;


}
