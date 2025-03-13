package bip.online.biplio2023.repository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface Book extends JpaRepository<bip.online.biplio2023.entity.Book, Long> {
}
