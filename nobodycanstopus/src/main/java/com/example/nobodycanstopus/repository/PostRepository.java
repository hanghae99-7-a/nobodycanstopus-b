package com.example.nobodycanstopus.repository;



import com.example.nobodycanstopus.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();
    }
