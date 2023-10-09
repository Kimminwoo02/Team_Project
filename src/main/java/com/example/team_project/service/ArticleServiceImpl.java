package com.example.team_project.service;

import com.example.team_project.dto.article.CreateArticle;
import com.example.team_project.entity.Article;
import com.example.team_project.entity.Member;
import com.example.team_project.repository.ArticleRepository;
import com.example.team_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    @Override
    public void write(CreateArticle createArticle) {
        Member member = memberRepository.getReferenceById(createArticle.getMember().getMemberId());
        Article article = createArticle.toCreateArticle();
        article.setMember(member);
        articleRepository.save(article);

    }
}
