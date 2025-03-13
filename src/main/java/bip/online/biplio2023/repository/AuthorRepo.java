package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
