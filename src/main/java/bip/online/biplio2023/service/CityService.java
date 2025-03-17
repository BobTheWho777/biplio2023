package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.CityEntity;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<CityEntity> findAll();

    Optional<CityEntity> findById(Long id);

    CityEntity save(CityEntity data);

    void update(CityEntity data);

    void deleteById(Long id);
}
