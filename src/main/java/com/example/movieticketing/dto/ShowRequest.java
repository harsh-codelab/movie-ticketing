package com.example.movieticketing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowRequest {

    @JsonProperty("show_id")
    String showId;

    @JsonProperty("cinema_name")
    String cinemaName;

    @JsonProperty("city_name")
    String cityName;

    @JsonProperty("show_available_from")
    LocalDateTime showAvailableFrom;

    @JsonProperty("show_available_till")
    LocalDateTime showAvailableTill;

}
