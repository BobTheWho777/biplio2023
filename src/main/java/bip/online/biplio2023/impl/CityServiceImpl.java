package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.repository.CityRepo;
import bip.online.biplio2023.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepo repo;

    public CityServiceImpl(CityRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<CityEntity> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<CityEntity> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public CityEntity save(CityEntity data) {
        return repo.save(data);
    }

    @Override
    public void update(CityEntity data) {
        repo.save(data);

    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
