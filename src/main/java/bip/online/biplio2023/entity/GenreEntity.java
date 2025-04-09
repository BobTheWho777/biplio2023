package bip.online.biplio2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<BookEntity> books;

    public GenreEntity() {
    }

    public GenreEntity(Long id, String title) {
        this.title = title;
        this.id = id;
    }

    public GenreEntity(Long id, String title, List<BookEntity> books) {
        this.id = id;
        this.title = title;
        this.books = books;
    }
}
