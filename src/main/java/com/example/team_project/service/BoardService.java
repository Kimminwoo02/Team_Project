package com.example.team_project.service;

import com.example.team_project.dto.Board.BoardCreate;
import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.Board.BoardUpdate;
import com.example.team_project.entity.Board;

import java.util.List;

public interface BoardService {

    public void write(BoardCreate boardCreate);
    public void delete(Long boardId);
    public void update(BoardUpdate boardUpdate, Long boardId);
    public List<BoardDTO> getBoardList();
    public BoardDTO getBoard(Long boardId);
}
