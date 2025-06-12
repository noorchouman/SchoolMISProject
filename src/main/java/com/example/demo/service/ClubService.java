package com.example.demo.service;

import com.example.demo.entities.Club;
import com.example.demo.repository.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private final ClubRepository clubRepository;
    
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }


    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Club getClubById(Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    public Club updateClub(Long id, Club updatedClub) {
        Club existing = clubRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedClub.getName());
            existing.setMembers(updatedClub.getMembers());
            return clubRepository.save(existing);
        }
        return null;
    }

    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }
    public List<Club> searchClubsByName(String name) {
        return clubRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Club> getClubsByMemberId(Long memberId) {
        return clubRepository.findByMembersId(memberId);
    }
}
