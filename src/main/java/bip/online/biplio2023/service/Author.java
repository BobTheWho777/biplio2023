package bip.online.biplio2023.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Author {
    private final Author repo;


    public List<Author> findAll(){
        return repo.findAll();
    }

    public Optional<Author> findById(Long id){
        return repo.findById(id);
    }

    public Author save (Author data){
        return repo.save(data);
    }

    public void update (Author data){
        repo.save(data);
    }
}
