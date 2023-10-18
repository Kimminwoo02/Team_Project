package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.security.CustomUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    void save(CommentDTO commentDTO, CustomUserDetails principalDetails);

    void delete(Long articleCommentId,String userId);

    List<CommentDTO> getComment(Long boardId,Pageable pageable);

}
