package com.example.itss20231.dao.response;

import com.example.itss20231.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private String content;
    private String user;
    private String createdAt;
}
