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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {
    @Mock
    private AuthorRepo authorRepo;

    @InjectMocks
    private AuthorServiceImpl authorService;

   @Test
    void findAll() {
       Long authorId1 = 1L;
       Long authorId2 = 2L;
       AuthorEntity author1 = new AuthorEntity(authorId1, "Петрович", "Петр", "Петров");
       AuthorEntity author2 = new AuthorEntity(authorId2, "Зубенко", "Михаил", "Петровович");
       when(authorRepo.findAll()).thenReturn(List.of(author1,author2));

       List<AuthorEntity> result = authorService.findAll();

       assertEquals(2, result.size());
       verify(authorRepo, times(1)).findAll();
   }

    @Test
    void findById() {
        Long authorId = 1L;
        AuthorEntity author = new AuthorEntity(authorId, "Петрович", "Петр", "Петров");

        when(authorRepo.findById(authorId)).thenReturn(Optional.of(author));

        Optional<AuthorEntity> result = authorService.findById(authorId);
        System.out.printf("Результат: %s %s %s", result.get().getName(), result.get().getSurname(), result.get().getLastname());

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
        AuthorEntity author = new AuthorEntity(1L, "Updated", "Author", null);

        authorService.update(author);

        verify(authorRepo, times(1)).save(author);
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(authorRepo).deleteById(id);

        authorService.deleteById(id);

        verify(authorRepo, times(1)).deleteById(id);
    }
}