package com.example.team_project.entity.member;

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

    @Setter
    private String folderPath;
    @Setter
    private String storeFileName;

}
