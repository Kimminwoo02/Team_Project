package com.example.team_project.repository;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.Board;
import com.example.team_project.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByIdAndCommentWriter(Long CommentId, String writer);

    Page<Comment> findByBoard_BoardId(Long boardId, Pageable pageable);

}
