package com.example.team_project.repository;

import com.example.team_project.entity.board.Board;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Override //기본 적으로 findAll 을 제공하기 때문에 Override 하여 재정의 후 사용
    @EntityGraph(attributePaths = {"board"})
    List<Board> findAll();
}
