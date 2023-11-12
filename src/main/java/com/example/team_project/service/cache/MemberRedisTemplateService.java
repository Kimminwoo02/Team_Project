package com.example.team_project.service.cache;

import com.example.team_project.dto.member.MemberDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberRedisTemplateService {

    private static final String CACHE_KEY = "MEMBER";

    private final RedisTemplate<String,Object> redisTemplate;

    // OjbectMapper는 싱글톤으로 등록해서 사용
    private final ObjectMapper objectMapper;

    // 1 : Cache key 값, 2 : 서브키, 3: 값. DTO를 스트링 형태로 변환하여 사용
    private HashOperations<String, String, String> hashOperations;

    @PostConstruct
    public void init(){
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(MemberDTO memberDTO){
        if(Objects.isNull(memberDTO) || Objects.isNull(memberDTO.getEmail())){
            log.error("에러입니다!");
            return;
        }
        try{
            hashOperations.put(
                    CACHE_KEY,
                    memberDTO.getEmail(),
                    serializedMemberDto(memberDTO)
            );

        }catch (Exception e){
            log.error("Save error", e.getMessage());
        }
    }

    private String serializedMemberDto(MemberDTO memberDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(memberDTO);
    }

    private MemberDTO deserializeMemberDto(String value) throws JsonProcessingException{
        return objectMapper.readValue(value,MemberDTO.class);
    }


}
