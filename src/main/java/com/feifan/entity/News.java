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
/*
Lombok还可以，注释写起来也累
 */
public class News {
    private Integer newsId;//id
    private Integer typeId;//type
    private String title;
    private LocalDateTime pubDate;
    private String author;
    private String content;
}
