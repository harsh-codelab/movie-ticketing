package com.example.movieticketing.entity;

import com.example.movieticketing.dto.BookingRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "booking_details")
@NoArgsConstructor
public class BookingDetails {

    @Id
    @Column(name = "id",nullable = false,unique = true)
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "show_id")
    Long showId = null ;

    @Column(name = "booked_seats")
    Integer bookedSeats = 0;

    public BookingDetails(BookingRequest request) {
        this.showId = request.getShowId();
        this.bookedSeats = request.getRequiredSeats();
    }
}
