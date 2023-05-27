package com.synnex.bookstore.repository;

import com.synnex.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
