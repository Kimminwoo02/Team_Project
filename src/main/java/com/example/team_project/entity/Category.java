package com.example.team_project.entity;


import lombok.Getter;




@Getter
public enum Category {
   SOCCER("축구"),
   BASKETBALL("농구"),
   BADMINTON("배드민턴"),
   HIKING("등산"),
   TENNIS("테니스"),
   HEALTH("헬스"),
   FOOT_VOLLEYBALL("족구"),
   CLIMBING("클라이밍"),
   TABLE_TENNIS("탁구"),
   BILLIARD("당구"),
   CULTURE("문화생활"),
   GAME("오락"),
   STUDY("스터디"),
   ETC("기타");

    private final String title;

    Category(String title){
        this.title = title;
    }


}
