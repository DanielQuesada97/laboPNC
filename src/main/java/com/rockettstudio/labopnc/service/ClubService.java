package com.rockettstudio.labopnc.service;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rockettstudio.labopnc.dto.ClubResponse;
import com.rockettstudio.labopnc.dto.CreateClubRequest;
import com.rockettstudio.labopnc.entity.Club;
import com.rockettstudio.labopnc.repository.ClubRepository;

@Service
@RequiredArgsConstructor
public class ClubService {
    
    private final ClubRepository clubRepository;

    public ClubResponse createClub(CreateClubRequest request) {
        Club club = new Club();
        club.setName(request.getName());
        club.setCountry(request.getCountry());
        club.setCoach(request.getCoach());
        club.setTitles(request.getTitles());

            Club savedClub = clubRepository.save(club);
            return mapToResponse(savedClub);
    }

    public List<ClubResponse> getAllClubs() {
        return clubRepository.findAll().stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
    }

    private ClubResponse mapToResponse(Club club) {
        ClubResponse response = new ClubResponse();
        response.setId(club.getId());
        response.setName(club.getName());
        response.setCoach(club.getCoach());
        response.setCountry(club.getCountry());
        response.setTitles(club.getTitles());
        return response;
    }

}

