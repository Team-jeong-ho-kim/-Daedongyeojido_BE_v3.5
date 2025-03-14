package com.example.daedongv3_5.domain.club.application;

import com.example.daedongv3_5.domain.club.application.facade.ClubFacade;
import com.example.daedongv3_5.domain.club.domain.Club;
import com.example.daedongv3_5.domain.club.domain.Major;
import com.example.daedongv3_5.domain.club.domain.repository.ClubRepository;
import com.example.daedongv3_5.domain.club.presentation.dto.request.UpdateClubRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UpdateClubInfoService {
    private final ClubRepository clubRepository;
    private final ClubFacade clubFacade;

    @Transactional
    public void updateClub(Long id, UpdateClubRequest request) {
        Club club = clubFacade.clubFacade(id);

        club.update(
                request.getClubName(),
                request.getIntroduction(),
                request.getOneLiner(),
                request.getMajors().stream().map(majorType -> new Major(majorType)).collect(Collectors.toList())
        );
    }

}
