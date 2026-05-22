package com.example.bookmanager.exception;

/**
 * 图书未找到异常
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("图书不存在，ID: " + id);
    }
}
