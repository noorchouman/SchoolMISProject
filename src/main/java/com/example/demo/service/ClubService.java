package com.example.demo.service;

import com.example.demo.entities.Club;
import com.example.demo.entities.Student;
import com.example.demo.repository.ClubRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService {

	@Autowired
    private final ClubRepository clubRepository;
    
    private final StudentRepository studentRepository;

    
    public ClubService(ClubRepository clubRepository, StudentRepository studentRepository) {
        this.clubRepository = clubRepository;
        this.studentRepository = studentRepository;
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

    @Transactional
    public void deleteClub(Long id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null && club.getMembers() != null) {
            
            List<Student> students = new ArrayList<>(club.getMembers());
            for (Student student : students) {
                student.getClubs().remove(club);
                studentRepository.save(student);
            }
            club.getMembers().clear();
            clubRepository.save(club); 
            clubRepository.delete(club);
        }
    }
    public List<Club> searchClubsByName(String name) {
        return clubRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Club> getClubsByMemberId(Long memberId) {
        return clubRepository.findByMembersId(memberId);
    }
}
