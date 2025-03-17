package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.repository.GenreRepo;
import bip.online.biplio2023.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepo repo;

    public GenreServiceImpl(GenreRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<GenreEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<GenreEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public GenreEntity save(GenreEntity data) {
        return repo.save(data);
    }

    @Override
    public void update(GenreEntity data) {
        repo.save(data);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
