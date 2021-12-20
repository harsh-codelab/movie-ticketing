package com.example.movieticketing.repository;

import com.example.movieticketing.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Long> {
    public BookingDetails findByShowId(Long userId);

}
