package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.board.Board;
import com.example.team_project.entity.board.Comment;
import com.example.team_project.entity.member.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.CommentRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void save(CommentDTO commentDTO,CustomUserDetails principalDetails) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long memberId = ((CustomUserDetails) principal).getMember().getMemberId();

        Board board = boardRepository.getReferenceById(commentDTO.getBoardId());
        Member member = memberRepository.getReferenceById(memberId);

        Comment comment = Comment.toComment(member.getNickName(), commentDTO.getCommentContents(), board);
        commentRepository.save(comment);

    }

    public void delete(Long articleCommentId,String userId) {
        commentRepository.deleteByIdAndCommentWriter(articleCommentId,userId);
    }

    @Override
    public List<CommentDTO> getComment(Long boardId, Pageable pageable) {
        Page<Comment> comments = commentRepository.findByBoard_BoardId(boardId, pageable);
        return comments.stream()
                .map(CommentDTO::from)
                .collect(Collectors.toList());
    }


}