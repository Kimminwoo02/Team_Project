package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CommentService {

    void save(CommentDTO commentDTO);

    void delete(Long articleCommentId,String userId);

    List<CommentDTO> getComment(Long boardId, int page, int size);

}
