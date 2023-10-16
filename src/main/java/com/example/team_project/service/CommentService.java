package com.example.team_project.service;

import com.example.team_project.dto.Board.BoardDTO;
import com.example.team_project.dto.ReviewDto;
import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.Board;
import com.example.team_project.entity.Comment;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.CommentRepository;
import com.example.team_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void save(CommentDTO commentDTO) {
        Board board = boardRepository.getReferenceById(commentDTO.getBoardId());
        Member member = new Member(memberRepository.getReferenceById(commentDTO.getMemberId()));
        Comment comment = Comment.toSaveEntity(member, board);
        commentRepository.save(comment);
    }

    public List<CommentDTO> findAll(Long boardId) {
        Board board = boardRepository.findById(boardId).get();
        List<Comment> commentList = commentRepository.findAllByBoardOrderByIdDesc(board);

        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Comment comment: commentList) {
            CommentDTO commentDTO = CommentDTO.toCommentDTO(comment, boardId);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }
}