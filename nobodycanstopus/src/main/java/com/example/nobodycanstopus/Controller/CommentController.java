package com.example.nobodycanstopus.Controller;

import com.example.nobodycanstopus.Model.Comment;
import com.example.nobodycanstopus.dto.CommentRequetsDto;
import com.example.nobodycanstopus.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글 게시글 ID 참조 하여 생성
    @PostMapping("/api/post/{postId}/comment")
    public Comment createComment(@RequestBody CommentRequetsDto requetsDto, @PathVariable Long postId) {
        return commentService.create(requetsDto, postId);
    }
    // 댓글 수정
    @PutMapping("/api/comment/{id}")
    public String updateComment(@PathVariable Long id, @RequestBody CommentRequetsDto requestsDto) {
        return commentService.update(id, requestsDto);
    }
    // 댓글 삭제
    @DeleteMapping("/api/comment/{id}")
    public String deleteComment(@PathVariable Long id, @RequestBody CommentRequetsDto requestsDto) {
        return commentService.delete(id, requestsDto);
    }
}
