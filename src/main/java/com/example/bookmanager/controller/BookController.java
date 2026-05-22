package com.example.bookmanager.controller;

import com.example.bookmanager.dto.BookRequest;
import com.example.bookmanager.dto.BookResponse;
import com.example.bookmanager.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书 REST 控制器
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * GET /api/books — 获取所有图书
     * GET /api/books?q=xxx — 搜索图书
     */
    @GetMapping
    public ResponseEntity<List<BookResponse>> list(@RequestParam(value = "q", required = false) String keyword) {
        List<BookResponse> books = bookService.search(keyword);
        return ResponseEntity.ok(books);
    }

    /**
     * GET /api/books/{id} — 获取单本图书
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) {
        BookResponse book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    /**
     * POST /api/books — 创建图书
     */
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest request) {
        BookResponse book = bookService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    /**
     * PUT /api/books/{id} — 更新图书
     */
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        BookResponse book = bookService.update(id, request);
        return ResponseEntity.ok(book);
    }

    /**
     * DELETE /api/books/{id} — 删除图书
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
