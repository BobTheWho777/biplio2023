package bip.online.biplio2023.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class City {
    private final City repo;

    public List<City> findAll(){
        return repo.findAll();
    }

    public Optional<City> findById(Long id){
        return repo.findById(id);
    }

    public City save (City data){
        return repo.save(data);
    }

    public void update (City data){
        repo.save(data);
    }
}
