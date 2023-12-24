package com.example.itss20231.repo;

import com.example.itss20231.dto.Comment;
import com.example.itss20231.dto.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByTourId(int tourId);
}
