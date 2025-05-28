package com.example.demo.repository;

import com.example.demo.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
