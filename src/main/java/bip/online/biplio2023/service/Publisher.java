package bip.online.biplio2023.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Publisher {
    private final Publisher repo;

    public List<Publisher> findAll(){
        return repo.findAll();
    }

    public Optional<Publisher> findById(Long id){
        return repo.findById(id);
    }

    public Publisher save (Publisher data){
        return repo.save(data);
    }

    public void update (Publisher data){
        repo.save(data);
    }
}