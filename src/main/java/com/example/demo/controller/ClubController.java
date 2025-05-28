package com.example.demo.controller;
import com.example.demo.Club;
import com.example.demo.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;
    @GetMapping
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }
    @GetMapping("/{id}")
    public Club getClubById(@PathVariable Long id) {
        return clubRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubRepository.save(club);
    }
    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Long id, @RequestBody Club updatedClub) {
        return clubRepository.findById(id).map(club -> {
            club.setName(updatedClub.getName());
            club.setMembers(updatedClub.getMembers()); // if updating members too
            return clubRepository.save(club);
        }).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Long id) {
        clubRepository.deleteById(id);
    }
}
