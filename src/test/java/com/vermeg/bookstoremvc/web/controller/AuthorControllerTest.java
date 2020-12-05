package com.vermeg.bookstoremvc.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vermeg.bookstoremvc.dao.entity.Author;
import com.vermeg.bookstoremvc.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.nio.cs.Surrogate.is;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthorServiceImpl authorService;

    @InjectMocks
    private AuthorController authorController;

    private List<Author> authors;

    private Author author;

    private ObjectMapper objectMapper;

    @BeforeAll
    void init() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(authorController).build();

        authors = new ArrayList<>();
        authors.add(new Author(1L, "William", "Shakespeare", "william@gmail.com"));
        authors.add(new Author(2L, "Franz", "Kafka", "franz@gmail.com"));
        authors.add(new Author(3L, "Nikola", "Tesla", "nicola@gmail.com"));

    }

    @BeforeEach
    void setUp() {
        author = new Author(1L, "Franz", "Kafka", "franz@gmail.com");
        objectMapper = new ObjectMapper();

    }

    @Test
    void getAllEntities() throws Exception {
        given(authorService.getAll()).willReturn(authors);
        this.mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]").exists())
                .andExpect(jsonPath("$.[0].id").value(authors.get(0).getId()));
    }

    @Test
    void getEntity() throws Throwable {
        final Long authorId = 1L;

        given(authorService.getById(author.getId())).willReturn(author);

        this.mockMvc.perform(get("/authors/{id}",authorId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(author.getName()))
                .andExpect(jsonPath("$.lastName").value(author.getLastName()))
                .andExpect(jsonPath("$.email").value(author.getEmail()));

    }

    @Test
    void addEntity() throws Throwable {
        Author author1 = new Author(null, "Franz", "Kafka", "franz@gmail.com");
        given(authorService.save(author1)).willReturn(author1);

        this.mockMvc.perform(post("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(author1.getName()))
                .andExpect(jsonPath("$.lastName").value(author1.getLastName()))
                .andExpect(jsonPath("$.email").value(author1.getEmail()));
    }

    @Test
    void deleteEntity() throws Exception {
        final Long authorId = 1L;
        given(authorService.deleteById(authorId)).willReturn(Boolean.TRUE);
        this.mockMvc.perform(delete("/authors/{id}",authorId))
                .andExpect(status().isOk());




    }

    @Test
    void update() throws Throwable {

        given(authorService.update(author)).willReturn(author);

        this.mockMvc.perform(put("/authors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(author.getName()))
                .andExpect(jsonPath("$.lastName").value(author.getLastName()))
                .andExpect(jsonPath("$.email").value(author.getEmail()));

    }
}