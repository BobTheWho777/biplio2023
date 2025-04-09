package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.repository.GenreRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenreServiceImplTest {
    @Mock
    private GenreRepo repo;

    @InjectMocks
    private GenreServiceImpl genreService;

    @Test
    void findAll() {
        GenreEntity gen1 = new GenreEntity(1L,"Комедия");
        GenreEntity gen2 = new GenreEntity(2L,"Романы");
        when(repo.findAll()).thenReturn(List.of(gen1,gen2));

        List<GenreEntity> result = genreService.findAll();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Комедия",
            "2, Триллер",
            "3, Детектив",
            "4, Роман",
            "5, Автобиография",
    })
    void findById(Long id, String title) {
        GenreEntity genre = new GenreEntity(id, title);
        when(repo.findById(id)).thenReturn(Optional.of(genre));

        Optional<GenreEntity> result = genreService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(title, result.get().getTitle());
        verify(repo).findById(id);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "РжакаКомедия",
            "Какой-то ужастик на UNITY",
            "Капитан Ебенграда съел все сухпайки(драма)",
            "Как починить генератор и не офигеть",
            "Винтерхоум пал мы следующие",
    })
    void save(String title) {
        GenreEntity newGenre = new GenreEntity(null, title);
        GenreEntity savedGenre = new GenreEntity(1L, title);

        when(repo.save(newGenre)).thenReturn(savedGenre);

        GenreEntity result = genreService.save(newGenre);

        assertNotNull(result.getId());
        assertEquals(title, result.getTitle());
        verify(repo).save(newGenre);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Жанр1",
            "2, Жанр2",
            "3, Жанр3",
            "4, Жанр4",
            "5, Жанр5",
    })
    void update(Long id, String title) {
        GenreEntity genre = new GenreEntity(id,title);
        genreService.update(genre);
        verify(repo).save(genre);
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(repo).deleteById(id);

        genreService.deleteById(id);

        verify(repo).deleteById(id);
    }
}