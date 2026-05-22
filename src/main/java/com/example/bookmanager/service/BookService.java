package com.example.bookmanager.service;

import com.example.bookmanager.dto.BookRequest;
import com.example.bookmanager.dto.BookResponse;

import java.util.List;

/**
 * 图书业务接口
 */
public interface BookService {

    /** 获取所有图书 */
    List<BookResponse> findAll();

    /** 根据 ID 获取单本图书 */
    BookResponse findById(Long id);

    /** 创建图书 */
    BookResponse create(BookRequest request);

    /** 更新图书 */
    BookResponse update(Long id, BookRequest request);

    /** 删除图书 */
    void delete(Long id);

    /** 按关键词搜索 */
    List<BookResponse> search(String keyword);
}
