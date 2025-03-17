package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;


public interface AuthorService {

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

    AuthorEntity save(AuthorEntity data);

    void update(AuthorEntity data);

    void deleteById(Long id);

    }


