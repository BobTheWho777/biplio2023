package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.repository.CityRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}