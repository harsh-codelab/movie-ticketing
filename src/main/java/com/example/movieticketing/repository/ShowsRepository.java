package com.example.movieticketing.repository;

import com.example.movieticketing.entity.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<Shows,Long> {
}
