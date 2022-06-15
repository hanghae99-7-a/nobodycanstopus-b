package com.example.nobodycanstopus.repository;

import com.example.nobodycanstopus.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment save(Comment comment);
}
