package com.example.movieticketing.repository;

import com.example.movieticketing.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long> {
    public UserDetails findByUserEmail(String userEmail);
}
