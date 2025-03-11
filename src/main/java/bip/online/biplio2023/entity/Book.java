package bip.online.biplio2023.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private String year;
}
