package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    BookEntity save(BookEntity data);

    void update(BookEntity data);

    void deleteById(Long id);
}
