package bip.online.biplio2023.repository;

import bip.online.biplio2023.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {
}
