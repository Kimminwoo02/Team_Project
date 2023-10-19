package com.example.team_project.repository;

import com.example.team_project.entity.board.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByIdAndMemberId(Long CommentId, Long memberId);

    Page<Comment> findByBoard_BoardId(Long boardId, Pageable pageable);

}
