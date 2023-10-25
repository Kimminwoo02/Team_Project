package com.example.team_project.service.matching;

import com.example.team_project.dto.matching.MatchingDTO;

import com.example.team_project.entity.Category;
import com.example.team_project.entity.matching.Matching;
import com.example.team_project.entity.matching.MatchingMember;
import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.MatchingRepository;
import com.example.team_project.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchingServiceImpl implements MatchingService {
    private final MatchingRepository matchingRepository;

    // 매칭 등록
    @Override
    public Long createMatching(MatchingDTO matchingDTO) {
        // transform DTO to Entity
        Matching matching = matchingDTO.createMatching();

        // get Authenticated logged-in object in session
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // casting logged-in object to member and get PK from entity(named Member)
        // Class CustomUserDetails contains object member type Member to get own PK.
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();
        matching.setMasterId(memberId);

//        Member와 N:M으로 통신하지 않기 위해

        matchingRepository.save(matching);
        return matching.getMatchingId();

    }

    @Override
    public List<Matching> findByCategory(Category category) {

        return matchingRepository.findByCategory(category);
    }

    // 매칭 맴버 등록
    @Override
    public List<Matching> findAll() {
        return matchingRepository.findAll();
    }

    @Override
    public Matching getMatching(Long matchingId) {
        return matchingRepository.findById(matchingId).orElseThrow();
    }

    @Override
    public List<MatchingDTO> findMyMatching() {

         return matchingRepository.findAllByMasterId(getMyId()).stream()
                 .map(MatchingDTO::from)
                 .collect(Collectors.toList());
    }


    public static Long getMyId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getMember().getMemberId();
    }
}
