package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.repository.PublisherRepo;
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
class PublisherServiceImplTest {
        CityEntity city1 = new CityEntity(1L, "Москва");
        CityEntity city2 = new CityEntity(2L, "Архангельск");

    @Mock
    private PublisherRepo repo;

    @InjectMocks
    private PublisherServiceImpl publisherService;

    @Test
    void findAll() {
        PublisherEntity pub1 = new PublisherEntity(1L,"НовыйГод",city1);
        PublisherEntity pub2 = new PublisherEntity(2L,"СтарыйМельник",city2);
        when(repo.findAll()).thenReturn(List.of(pub1,pub2));

        List<PublisherEntity> result = publisherService.findAll();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Правда",
            "2, Ложь",
            "3, Бочка",
            "4, Крутое Пике",
            "5, Громкий Дэн",
    })
    void findById(Long id, String title) {
        PublisherEntity pub = new PublisherEntity(id, title);
        when(repo.findById(id)).thenReturn(Optional.of(pub));

        Optional<PublisherEntity> result = publisherService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(title, result.get().getTitle());
        verify(repo).findById(id);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Гойдаслав",
            "НовыйПитер",
            "ПодземкаМосквы",
            "ЫыыыыБбыыавы",
            "Абчихба",
            "Игра в Амара"
    })
    void save(String title) {
        PublisherEntity newPub = new PublisherEntity(null, title);
        PublisherEntity savedPub = new PublisherEntity(1L, title);

        when(repo.save(newPub)).thenReturn(savedPub);

        PublisherEntity result = publisherService.save(newPub);

        assertNotNull(result.getId());
        assertEquals(title, result.getTitle());
        verify(repo).save(newPub);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, жанр",
            "2, какой-то жанр",
            "3, ещё жанр ",
            "4, ещё больше жанров",
            "5, жанр жанром жарится"

    })
    void update(Long id, String title) {
        PublisherEntity pub = new PublisherEntity(id,title);
        publisherService.update(pub);

        verify(repo).save(pub);
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(repo).deleteById(id);

        publisherService.deleteById(id);

        verify(repo).deleteById(id);
    }
}