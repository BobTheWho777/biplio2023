package bip.online.biplio2023.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Genre {
    private final Genre repo;

    public List<Genre> findAll(){
        return repo.findAll();
    }

    public Optional<Genre> findById(Long id){
        return repo.findById(id);
    }

    public Genre save (Genre data){
        return repo.save(data);
    }

    public void update (Genre data){
        repo.save(data);
    }
}

