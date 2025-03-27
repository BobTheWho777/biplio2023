package bip.online.biplio2023.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity {
    public BookEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
    private String year;

    public BookEntity(Long id, String title, AuthorEntity author, PublisherEntity publisher, GenreEntity genre, String year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.year = year;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public AuthorEntity getAuthor() {return author;}

    public void setAuthor(AuthorEntity author) {this.author = author;}

    public PublisherEntity getPublisher() {return publisher;}

    public void setPublisher(PublisherEntity publisher) {this.publisher = publisher;}

    public GenreEntity getGenre() {return genre;}

    public void setGenre(GenreEntity genre) {this.genre = genre;}

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}
}
