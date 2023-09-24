package com.example.team_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"member"})
public class MemberImg {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_img_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable = false)
    private Member member;

    private String folderPath;

    private String storeFileName;

}
