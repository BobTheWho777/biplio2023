package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.repository.CityRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {

    @Mock
    private CityRepo repo;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    void findAll() {
        Long cityId1 = 1L;
        Long cityId2 = 2L;
        CityEntity city1 = new CityEntity(cityId1,"Белореченск");
        CityEntity city2 = new CityEntity(cityId2, "Краснодар");
        when(repo.findAll()).thenReturn(List.of(city1,city2));

        List<CityEntity> result = cityService.findAll();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Краснодар",
            "2, Майкоп",
            "3, Крыжополь",
            "4, Подольск",
            "4, Москва"
    })
    void findById(Long id, String title) {
        CityEntity city = new CityEntity(id,title);
        when(repo.findById(id)).thenReturn(Optional.of(city));

        Optional<CityEntity> result = cityService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(title, result.get().getTitle());
        verify(repo).findById(id);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "Архангельск",
            "Тюмень",
            "Омск",
            "Екатеринбург",
            "Ростов-на-Дону",
    })
    void save(String title){
        CityEntity newCity = new CityEntity(null,title);
        CityEntity savedCity = new CityEntity(1L,title);

        when(repo.save(newCity)).thenReturn(savedCity);

        CityEntity result = cityService.save(newCity);

        assertNotNull(result.getId());
        assertEquals(title, result.getTitle());
        verify(repo).save(newCity);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,Архангельск",
            "2,Тюмень",
            "3,Омск",
            "4,Екатеринбург",
            "5,Ростов-на-Дону",
    })
    void update(Long id, String title) {
        CityEntity city = new CityEntity(id,title);
        cityService.update(city);

        verify(repo).save(city);
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(repo).deleteById(id);

        cityService.deleteById(id);

        verify(repo).deleteById(id);
    }
}