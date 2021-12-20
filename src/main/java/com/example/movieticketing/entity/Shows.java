package com.example.movieticketing.entity;

import com.example.movieticketing.dto.CreateShow;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
public class Shows {

    @Id
    @Column(name = "id",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("show_id")
    Long id;

    @Column(name = "movie_name")
    @JsonProperty("movie_name")
    String movieName;

    @Column(name = "cinema_name")
    @JsonProperty("cinema_name")
    String cinemaName;

    @Column(name = "city_name")
    @JsonProperty("city_name")
    String cityName;

    @Column(name = "available_from")
    @JsonProperty("available_from")
    LocalDateTime availableFrom;

    @Column(name = "available_till")
    @JsonProperty("available_till")
    LocalDateTime availableTill;

    @Column(name = "movie_price")
    @JsonProperty("movie_price")
    Integer price;

    @Column(name = "total_seats")
    @JsonProperty("total_seats")
    Integer totalSeats;

    public Shows(CreateShow show) {
        this.movieName = show.getMovieName();
        this.cinemaName = show.getCinemaName();
        this.availableFrom = show.getAvailableFrom();
        this.availableTill = show.getAvailableTill();
        this.price = show.getPrice();
        this.totalSeats = show.getTotalSeats();
        this.cityName = show.getCityName();
    }
}
