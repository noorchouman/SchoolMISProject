package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {

	List<Club> findByNameContainingIgnoreCase(String name);

	List<Club> findByMembersId(Long memberId);
}
