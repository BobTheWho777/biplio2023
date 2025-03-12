package bip.online.biplio2023.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Book {
    private final Book repo;

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Optional<Book> findById(Long id){
        return repo.findById(id);
    }

    public Book save (Book data){
        return repo.save(data);
    }

    public void update (Book data){
        repo.save(data);
    }
}
