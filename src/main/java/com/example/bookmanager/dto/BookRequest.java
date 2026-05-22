package com.example.bookmanager.dto;

import jakarta.validation.constraints.*;

/**
 * 创建/更新图书的请求 DTO
 */
public class BookRequest {

    @NotBlank(message = "书名不能为空")
    @Size(max = 200, message = "书名不能超过 200 个字符")
    private String title;

    @NotBlank(message = "作者不能为空")
    @Size(max = 100, message = "作者名不能超过 100 个字符")
    private String author;

    @Pattern(regexp = "^(\\d[- ]?){10}|(\\d[- ]?){13}$",
             message = "ISBN 格式不正确（10 位或 13 位数字）")
    private String isbn;

    @Size(max = 50, message = "出版社名不能超过 50 个字符")
    private String publisher;

    @Min(value = 1000, message = "出版年份不合法")
    @Max(value = 9999, message = "出版年份不合法")
    private Integer publishYear;

    @Size(max = 2000, message = "描述不能超过 2000 个字符")
    private String description;

    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.01", message = "价格必须大于 0")
    @DecimalMax(value = "99999.99", message = "价格不能超过 99999.99")
    private Double price;

    // ===== Getters & Setters =====

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
