package com.example.team_project.service.comment;

import com.example.team_project.dto.comment.CommentDTO;
import com.example.team_project.entity.Board;
import com.example.team_project.entity.Comment;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.BoardRepository;
import com.example.team_project.repository.CommentRepository;
import com.example.team_project.repository.MemberRepository;
import com.example.team_project.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
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

    public void save(CommentDTO commentDTO) {
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
    public List<CommentDTO> getComment(Long boardId) {
        return  commentRepository.findByBoard_BoardId(boardId)
                    .stream()
                    .map(CommentDTO::from)
                    .collect(Collectors.toList());
    }
}