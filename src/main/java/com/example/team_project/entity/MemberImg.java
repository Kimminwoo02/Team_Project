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
    @Column(name = "IMG_ID")
    private Long imgId;

    @OneToOne
    @JoinColumn(name = "memberId")
    private Member member;

    private String folderPath;

    private String storeFileName;

}
