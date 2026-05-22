package com.example.bookmanager.service;

import com.example.bookmanager.dto.BookRequest;
import com.example.bookmanager.dto.BookResponse;
import com.example.bookmanager.entity.Book;
import com.example.bookmanager.exception.BookNotFoundException;
import com.example.bookmanager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书业务实现
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::fromEntity)
                .toList();
    }

    @Override
    public BookResponse findById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return BookResponse.fromEntity(book);
    }

    @Override
    public BookResponse create(BookRequest request) {
        Book book = new Book();
        copyProperties(book, request);
        Book saved = bookRepository.save(book);
        return BookResponse.fromEntity(saved);
    }

    @Override
    public BookResponse update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        copyProperties(book, request);
        Book saved = bookRepository.save(book);
        return BookResponse.fromEntity(saved);
    }

    @Override
    public void delete(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponse> search(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }
        return bookRepository.search(keyword)
                .stream()
                .map(BookResponse::fromEntity)
                .toList();
    }

    /**
     * 将请求 DTO 的属性复制到实体
     */
    private void copyProperties(Book book, BookRequest request) {
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setPublisher(request.getPublisher());
        book.setPublishYear(request.getPublishYear());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
    }
}
