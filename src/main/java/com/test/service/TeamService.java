package com.test.service;

import com.test.domain.Member;
import com.test.domain.Team;
import com.test.respotiroy.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Member> findAllTeamMember(Long teamId) {
        Team findTeam = teamRepository.findById(teamId).orElseThrow(IllegalArgumentException::new);
        return findTeam.getMemberList();
    }
}
