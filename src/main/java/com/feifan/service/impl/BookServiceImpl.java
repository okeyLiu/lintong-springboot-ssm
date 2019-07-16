package com.feifan.service.impl;

import com.feifan.dao.BookDAO;
import com.feifan.entity.Book;
import com.feifan.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
//@Transactional//事务控制 全部方法都会事务处理
public class BookServiceImpl implements BookService {

    @Resource
    private BookDAO dao;

    @Override
    public List<Book> findAll() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* 集合容器不要返回null，返回空集合（元素个数为0） */
        return Collections.EMPTY_LIST;
    }

    @Override
    //@Transactional//事务控制 只是本方法
    public Optional<Book> findById(Integer id) {
        try {
            return Optional.of(dao.findOne(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
