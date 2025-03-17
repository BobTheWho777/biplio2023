package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.repository.BookRepo;
import bip.online.biplio2023.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookServiceImpl implements BookService {
    private final BookRepo repo;

    public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<BookEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<BookEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public BookEntity save(BookEntity data) {
        return repo.save(data);
    }

    @Override
    public void update(BookEntity data) {
        repo.save(data);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
