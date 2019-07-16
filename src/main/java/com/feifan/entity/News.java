package com.feifan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private Integer newsId;
    private Integer typeId;
    private String title;
    private LocalDateTime pubDate;
    private String author;
    private String content;
}
