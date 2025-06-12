package com.example.demo.service.test;

import com.example.demo.entities.Club;
import com.example.demo.repository.ClubRepository;
import com.example.demo.service.ClubService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ClubServiceTest {

    @Mock
    private ClubRepository clubRepository;

    @InjectMocks
    private ClubService clubService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClub() {
        Club club = new Club();
        club.setName("Chess Club");

        when(clubRepository.save(club)).thenReturn(club);

        Club saved = clubService.saveClub(club);
        assertThat(saved).isEqualTo(club);

        verify(clubRepository, times(1)).save(club);
    }

    @Test
    void testGetAllClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club());
        clubs.add(new Club());

        when(clubRepository.findAll()).thenReturn(clubs);

        List<Club> result = clubService.getAllClubs();
        assertThat(result).hasSize(2);

        verify(clubRepository, times(1)).findAll();
    }

    @Test
    void testGetClubById_Found() {
        Club club = new Club();
        club.setId(1L);

        when(clubRepository.findById(1L)).thenReturn(Optional.of(club));

        Club found = clubService.getClubById(1L);
        assertThat(found).isEqualTo(club);

        verify(clubRepository, times(1)).findById(1L);
    }

    @Test
    void testGetClubById_NotFound() {
        when(clubRepository.findById(1L)).thenReturn(Optional.empty());

        Club found = clubService.getClubById(1L);
        assertThat(found).isNull();

        verify(clubRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateClub_Found() {
        Club existing = new Club();
        existing.setId(1L);
        existing.setName("Old Name");

        Club updated = new Club();
        updated.setName("New Name");

        when(clubRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(clubRepository.save(any(Club.class))).thenReturn(existing);

        Club result = clubService.updateClub(1L, updated);
        assertThat(result.getName()).isEqualTo("New Name");

        verify(clubRepository, times(1)).findById(1L);
        verify(clubRepository, times(1)).save(existing);
    }

    @Test
    void testUpdateClub_NotFound() {
        when(clubRepository.findById(1L)).thenReturn(Optional.empty());

        Club updated = new Club();
        updated.setName("New Name");

        Club result = clubService.updateClub(1L, updated);
        assertThat(result).isNull();

        verify(clubRepository, times(1)).findById(1L);
        verify(clubRepository, never()).save(any());
    }

    @Test
    void testDeleteClub() {
        doNothing().when(clubRepository).deleteById(1L);

        clubService.deleteClub(1L);

        verify(clubRepository, times(1)).deleteById(1L);
    }

    @Test
    void testSearchClubsByName() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club());

        when(clubRepository.findByNameContainingIgnoreCase("chess")).thenReturn(clubs);

        List<Club> result = clubService.searchClubsByName("chess");
        assertThat(result).isNotEmpty();

        verify(clubRepository, times(1)).findByNameContainingIgnoreCase("chess");
    }

    @Test
    void testGetClubsByMemberId() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club());

        when(clubRepository.findByMembersId(5L)).thenReturn(clubs);

        List<Club> result = clubService.getClubsByMemberId(5L);
        assertThat(result).isNotEmpty();

        verify(clubRepository, times(1)).findByMembersId(5L);
    }
}

