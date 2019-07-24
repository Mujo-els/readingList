package com.example.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,String> {
    List<Book> findByReader(String reader);
}
