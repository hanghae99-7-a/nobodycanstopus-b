package com.example.nobodycanstopus.Model;

import com.example.nobodycanstopus.dto.CommentRequetsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "postId")
    private Post post;

    @Column(nullable = false)
    private  String comment;

    public Comment(CommentRequetsDto requetsDto, Post post) {
        this.comment = requetsDto.getComment();
        this.post = post;

    }

    public void update(CommentRequetsDto requestsDto) {
        this.comment = requestsDto.getComment();
    }
}

