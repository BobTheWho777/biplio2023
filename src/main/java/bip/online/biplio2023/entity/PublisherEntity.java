package bip.online.biplio2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "publishers")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
    @JsonIgnore
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<BookEntity> books;

    public PublisherEntity(Long id, String title, CityEntity city) {
        this.id = id;
        this.title = title;
        this.city = city;
    }

    public PublisherEntity(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public PublisherEntity() {
    }

    public PublisherEntity(Long id, String title, CityEntity city, List<BookEntity> books) {
        this.id = id;
        this.title = title;
        this.city = city;
        this.books = books;
    }
}
