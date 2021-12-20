package com.example.movieticketing.repository;

import com.example.movieticketing.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<UserSession,Long> {

    public UserSession findByUserId(Long userId);

}
