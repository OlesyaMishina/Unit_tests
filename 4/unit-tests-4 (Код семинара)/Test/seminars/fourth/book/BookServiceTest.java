package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookService bookService;
    BookRepository bookRepository;

    @BeforeEach
    void  setUp(){
        bookRepository = mock(BookRepository.class);
        bookService= new BookService(bookRepository);
    }


    @Test
    void findBookByIdTest() {
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Tittle", "Author"));

        String expecktedId =bookService.findBookById("1").getId();

        assertEquals(bookService.findBookById("1").getId(), "1");
    }


    @Test
    void findAllBooksTest() {
        when(bookRepository.findAll()).thenReturn(new ArrayList<Book>(Arrays.asList(
                new Book("1", "Title1", "Author1"),
                new Book("2", "Title2", "Author2"),
                new Book("3", "Title3", "Author3"))));

        int size=bookService.findAllBooks().size();

        assertEquals(size, 3);
    }

}