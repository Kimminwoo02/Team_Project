package com.example.team_project.repository;

import com.example.team_project.dto.member.MemberSearchCond;
import com.example.team_project.entity.member.Member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Mapper
@Repository
public interface MemberRepositoryMybatis {
    Optional<Member> findByEmailMybatis(String email);

    void saveWithoutFileMybatis(Member member);


    Optional<Member> findByIdMybatis(Long id);
    List<Member> findAllMybatis(MemberSearchCond memberSearchCond);
}
