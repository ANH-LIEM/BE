package com.example.itss20231.service;

import com.example.itss20231.dao.request.CommentRequest;
import com.example.itss20231.dao.response.CommentResponse;
import com.example.itss20231.dto.Comment;
import com.example.itss20231.dto.Contract;
import com.example.itss20231.dto.Tour;
import com.example.itss20231.dto.User;
import com.example.itss20231.repo.CommentRepo;
import com.example.itss20231.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final UserServiceImpl userService;
    private final TourService tourService;
    private final User currentUser;

    public Comment saveComment(CommentRequest commentRequest) {
        Comment comment = new Comment();
        comment.setUser(userService.getUserByEmail(currentUser.getEmail()));
        comment.setTour(tourService.getTourById(commentRequest.getTourId()));
        comment.setContent(commentRequest.getContent());
        return commentRepo.save(comment);
    }

    public List<CommentResponse> getAllCommentByTourId(int tourId) {
        List<CommentResponse> responses = new ArrayList<>();
        List<Comment> comments =  commentRepo.findAllByTourId(tourId);
        for (Comment comment : comments) {
            responses.add(CommentResponse.builder()
                    .createdAt(String.valueOf(comment.getCreatedAt()))
                    .content(comment.getContent())
                    .user(comment.getUser().getName())
                    .build());
        }
        return responses;
    }

}
