package com.synnex.bookstore.service;

import com.synnex.bookstore.entity.Book;
import com.synnex.bookstore.exception.BookNotFoundException;
import com.synnex.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        try {
            return (List<Book>) bookRepository.findAll();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error retrieving books: " + ex.getMessage(), ex);
        }
    }

    public Book getBookById(Long _id) {
        return bookRepository.findById(_id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + _id));
    }

    public Book saveBook(Book book) {
        try {
            return bookRepository.save(book);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error saving book: " + ex.getMessage(), ex);
        }
    }

    public void deleteBook(Long _id) {
        try {
            bookRepository.deleteById(_id);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error deleting book with ID : " + _id + ": " + ex.getMessage(), ex);
        }
    }

    public boolean existsById(Long _id) {
        return bookRepository.existsById(_id);
    }
}
