package com.example.nobodycanstopus.dto;

import lombok.Getter;

@Getter
public class PostRequestsDto {
    private String title;
    private String imageurl;
    private String content;
    private Long userId;
}
