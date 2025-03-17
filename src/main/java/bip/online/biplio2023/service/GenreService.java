package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.GenreEntity;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreEntity> findAll();

    Optional<GenreEntity> findById(Long id);

    GenreEntity save(GenreEntity data);

    void update(GenreEntity data);

    void deleteById(Long id);
}
