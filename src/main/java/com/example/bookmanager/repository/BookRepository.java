package com.example.bookmanager.repository;

import com.example.bookmanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图书数据访问层
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /** 按书名精确查找 */
    List<Book> findByTitle(String title);

    /** 按作者查找 */
    List<Book> findByAuthor(String author);

    /** 按书名模糊搜索（忽略大小写） */
    List<Book> findByTitleContainingIgnoreCase(String keyword);

    /** 按价格区间查找 */
    List<Book> findByPriceBetween(Double min, Double max);

    /** 综合搜索：书名或作者或出版社模糊匹配 */
    @Query("""
        SELECT b FROM Book b
        WHERE LOWER(b.title)   LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(b.author)  LIKE LOWER(CONCAT('%', :keyword, '%'))
           OR LOWER(b.publisher) LIKE LOWER(CONCAT('%', :keyword, '%'))
        ORDER BY b.updatedAt DESC
    """)
    List<Book> search(@Param("keyword") String keyword);
}
