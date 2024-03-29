package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.board.Comment;
import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.CommentRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void save(CommentDTO commentDTO) {
        Board board = boardRepository.getReferenceById(commentDTO.getBoardId());
        Comment comment = Comment.toComment(getMyId(), commentDTO.getCommentContents(), board);
        commentRepository.save(comment);
    }

    public void delete(Long articleCommentId) {
        commentRepository.deleteByIdAndMemberId(articleCommentId,getMyId());
    }

    @Override
    public List<CommentDTO> getComment(Long boardId, Pageable pageable) {
        Page<Comment> comments = commentRepository.findByBoard_BoardId(boardId, pageable);
        return comments.stream()
                .map(CommentDTO::from)
                .collect(Collectors.toList());
    }

    public static Long getMyId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((CustomUserDetails) principal).getMember().getMemberId();

    }

}