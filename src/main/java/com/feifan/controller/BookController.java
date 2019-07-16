package com.feifan.controller;

import com.feifan.entity.Book;
import com.feifan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin//开启跨域穿透，即其他服务器可以直接访问  不用考虑跨域！！！
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> getAll(){
        return bookService.findAll();
    }

}
