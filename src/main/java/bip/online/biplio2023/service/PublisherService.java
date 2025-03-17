package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.PublisherEntity;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<PublisherEntity> findAll();

    Optional<PublisherEntity> findById(Long id);

    PublisherEntity save(PublisherEntity data);

    void update(PublisherEntity data);

    void deleteById(Long id);
}
