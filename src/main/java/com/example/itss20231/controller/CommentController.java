package com.example.itss20231.controller;

import com.example.itss20231.dao.request.CommentRequest;
import com.example.itss20231.dao.response.CommentResponse;
import com.example.itss20231.dto.Comment;
import com.example.itss20231.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/tour/comment/{id}")
    public List<CommentResponse> getAllCommentByTourId(@PathVariable int id) {
        return commentService.getAllCommentByTourId(id);
    }

    @PostMapping("/tour/comment")
    public ResponseEntity<Comment> createComment(@RequestBody CommentRequest comment) {
        Comment createdComment = commentService.saveComment(comment);
        return ResponseEntity.ok().body(createdComment);
    }

}
