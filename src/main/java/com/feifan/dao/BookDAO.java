package com.feifan.dao;

import com.feifan.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookDAO {//DAO 规范 要求全大写，data access object

    /**
     * 获取所有book
     * @return
     */
    List<Book> findAll() throws Exception;

    /**
     * 找一个
     * @param id
     * @return
     * @throws Exception
     */
    Book findOne(Integer id) throws Exception;
}
