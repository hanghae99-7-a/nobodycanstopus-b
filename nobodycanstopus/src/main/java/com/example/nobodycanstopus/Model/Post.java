package com.example.nobodycanstopus.Model;

import com.example.nobodycanstopus.dto.PostRequestsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor // 기본 생성자 만듬.
@Getter // 조회를 하기 위해 있어야 됨.
@Entity // 테이블과 연계됨을 스프링에게 알려줌
public class Post extends Timestamped { // 생성 , 수정 시간을 자동으로 만듬.

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id //고유 아이디
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userNumber")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();


    // 제목
    @Column(nullable = false)
    private String title;

    // 이미지
    @Column
    private String imageurl;

    // 작성글
    @Column
    private String content;

    public Post(PostRequestsDto requestsDto, User user) {
        this.title = requestsDto.getTitle();
        this.content = requestsDto.getContent();
        this.imageurl = requestsDto.getImageurl();
        this.user = user;
    }

    public void update(PostRequestsDto requestsDto) {

        this.title = requestsDto.getTitle();
        this.content = requestsDto.getContent();
        this.imageurl = requestsDto.getImageurl();
    }
}
