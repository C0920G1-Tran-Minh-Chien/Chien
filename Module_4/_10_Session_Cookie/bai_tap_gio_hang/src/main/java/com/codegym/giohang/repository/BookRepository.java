package com.codegym.giohang.repository;

import com.codegym.giohang.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
