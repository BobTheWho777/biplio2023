package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.repository.PublisherRepo;
import bip.online.biplio2023.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    final private PublisherRepo repo;

    public PublisherServiceImpl(PublisherRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<PublisherEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<PublisherEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public PublisherEntity save(PublisherEntity data) {
        return repo.save(data);
    }

    @Override
    public void update(PublisherEntity data) {
        repo.save(data);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
