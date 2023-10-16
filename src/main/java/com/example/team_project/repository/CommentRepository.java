package com.example.team_project.repository;

import com.example.team_project.entity.Board;
import com.example.team_project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // select * from comment_table where board_id=? order by id desc;

    List<Comment> findAllByBoardOrderByIdDesc(Board board);


}
