package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.repository.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith((MockitoExtension.class))
class AuthorServiceImplTest {
    @Mock
    private AuthorRepo authorRepo;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void findAll() {

    }

    @Test
    void findById() {
        Long authorId = 1L;
        AuthorEntity author = new AuthorEntity(authorId, "Петрович", "Петр", "Петров");

        when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));

        Optional<AuthorEntity> result = authorService.findById(authorId);
        System.out.printf("Результат: %s %s %s", result.get().getName(), result.get().getSurname(), result.get().getLastName());

        assertTrue(result.isPresent());
        assertEquals("Петр", result.get().getName());
        verify(authorRepo, times(1)).findById(authorId);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1, Иванович, Иван, Иванов",
            "2, Петрович, Иван, Иванов",
            "3, Владленович, Иван, Иванов",
            "4, Головач, Лена, Иванов"
    })
    void save(Long id, String name, String surName, String lastName) {
        AuthorEntity author = new AuthorEntity(id, lastName, name, surName);

        when(authorRepo.save(author)).thenReturn(author);

        AuthorEntity result = authorService.save(author);

        assertEquals(result, author);
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(AuthorRepo).deleteById(id);

        authorService.deleteById(id);

        verify(AuthorRepo, times(1)).deleteById(id);
    }
}