package com.example.nobodycanstopus.service;

import com.example.nobodycanstopus.Model.Comment;
import com.example.nobodycanstopus.Model.Post;
import com.example.nobodycanstopus.dto.CommentRequetsDto;
import com.example.nobodycanstopus.repository.CommentRepository;
import com.example.nobodycanstopus.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Comment create(CommentRequetsDto requetsDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Comment comment = new Comment(requetsDto, post);
        return commentRepository.save(comment);
    }

    @Transactional
    public String update(Long id, CommentRequetsDto requestsDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        comment.update(requestsDto);
        return "로그인 구현 되면 완성하겠습니다";
    }
    @Transactional
    public String delete(Long id, CommentRequetsDto requestsDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
        return "로그인 구현 되면 완성하겠습니다";
    }
}
