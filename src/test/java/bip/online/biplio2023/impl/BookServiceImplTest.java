package bip.online.biplio2023.impl;

import bip.online.biplio2023.entity.BookEntity;
import bip.online.biplio2023.repository.BookRepo;
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
class BookServiceImplTest {

    @Mock
    private BookRepo repo;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void findAll() {
        Long bookId1 = 1L;
        Long bookId2 = 2L;
        BookEntity book1 = new BookEntity(bookId1,"Злые волки у ели");
        BookEntity book2 = new BookEntity(bookId2, "Он и балл принцесс");
        when(repo.findAll()).thenReturn(List.of(book1,book2));

        List<BookEntity> result = bookService.findAll();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Война и мир",
            "2, Три мушкетёра",
            "3, Божественная комедия",
            "4, Азбука СВО",
            "5, Тихий Дэн",
    })
    void findById(Long id, String title) {
        BookEntity book = new BookEntity(id, title);
        when(repo.findById(id)).thenReturn(Optional.of(book));

        Optional<BookEntity> result = bookService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
        assertEquals(title, result.get().getTitle());
        verify(repo).findById(id);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "кНигга 1",
            "Кухня СТС за кадром",
            "Книга с очень длинным названием",
            "Яфа Шист - путь к успеху",
            "Игра в Амара"
    })
    void save(String title) {
        BookEntity newBook = new BookEntity(null, title);
        BookEntity savedBook = new BookEntity(1L, title);

        when(repo.save(newBook)).thenReturn(savedBook);

        BookEntity result = bookService.save(newBook);

        assertNotNull(result.getId());
        assertEquals(title, result.getTitle());
        verify(repo).save(newBook);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, Книга намбер уан",
            "2, Вторая очень важная книга",
            "3, Третья волшебная ",
            "4, Я устал придумывать название",
            "5, Хочу пиццу книга"

    })
    void update(Long id, String title) {
        BookEntity book = new BookEntity(id,title);
        bookService.update(book);

        verify(repo).save(book);
    }

    @Test
    void deleteById() {
        Long id = 1L;
        doNothing().when(repo).deleteById(id);

        bookService.deleteById(id);

        verify(repo).deleteById(id);
    }
}