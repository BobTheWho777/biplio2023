package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.repository.AuthorRepo;
import bip.online.biplio2023.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepo repo;

    public AuthorServiceImpl(AuthorRepo repo) {
        this.repo = repo;
    }

    public List<AuthorEntity> findAll(){
        return repo.findAll();
    }

    public Optional<AuthorEntity> findById(Long id){
        return repo.findById(id);
    }

    public AuthorEntity save (AuthorEntity data){
        return repo.save(data);
    }

    public void update (AuthorEntity data){
        repo.save(data);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
