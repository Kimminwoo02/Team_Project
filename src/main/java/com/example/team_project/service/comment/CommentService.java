package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;

public interface CommentService {

    void save(CommentDTO commentDTO);

    void delete(Long articleCommentId,String userId);

}
