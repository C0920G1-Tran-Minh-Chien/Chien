package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
