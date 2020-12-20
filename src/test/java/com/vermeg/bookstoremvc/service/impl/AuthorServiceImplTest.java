//package com.vermeg.bookstoremvc.service.impl;
//
//import com.vermeg.bookstoremvc.dao.entity.Author;
//import com.vermeg.bookstoremvc.dao.repository.impl.AuthorRepositoryImpl;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith({MockitoExtension.class})
//class AuthorServiceImplTest {
//
//    @Mock
//    private AuthorRepositoryImpl authorRepository;
//
//    @InjectMocks
//    private AuthorServiceImpl authorService;
//
//    private List<Author> authors;
//
//    private Author author;
//
//    @BeforeEach
//    void setUp() {
//        authors = new ArrayList<>();
//        authors.add(new Author(1L, "William", "Shakespeare", "william@gmail.com"));
//        authors.add(new Author(2L, "Franz", "Kafka", "franz@gmail.com"));
//        authors.add(new Author(3L, "Nikola", "Tesla", "nicola@gmail.com"));
//
//        author = new Author(1L, "Franz", "Kafka", "franz@gmail.com");
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void getAll() {
//
//        given(authorRepository.findAll()).willReturn(authors);
//
//        List<Author> expected = authorService.getAll();
//
//        assertEquals(expected, authors);
//
//    }
//
//    @SneakyThrows
//    @Test
//    void getById() {
//        final Long id = 1L;
//        given(authorRepository.findById(id)).willReturn(Optional.of(author));
//        final Author expected = authorService.getById(id);
//        assertNotNull(expected);
//    }
//
//    @SneakyThrows
//    @Test
//    void save() {
//
//        given(authorRepository.save(author)).willReturn(Optional.of(author));
//        Author savedAuthor = authorService.save(author);
//        assertNotNull(savedAuthor);
//
//        verify(authorRepository).save(Mockito.any(Author.class));
//
//
//    }
//
//    @Test
//    void deleteById() {
//        final Long authorId = 1L;
//        authorService.deleteById(authorId);
//        authorService.deleteById(authorId);
//
//        verify(authorRepository, times(2)).deleteById(authorId);
//    }
//
//    @Test
//    void update() {
//        given(authorRepository.update(author)).willReturn(Optional.of(author));
//
//        final Author expected = authorService.update(author);
//
//        assertEquals(expected, author);
//
//        Mockito.verify(authorRepository).update(Mockito.any(Author.class));
//    }
//}
