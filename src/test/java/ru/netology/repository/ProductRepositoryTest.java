package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Pride and Prejudice", 300, "Jane Austen", 890, 1813);
    Book book2 = new Book(2, "The Great Gatsby", 500, "Francis Scott Key Fitzgerald", 990, 18925);
    Book book3 = new Book(3, "Jane Eyre", 100, "Charlotte Bronte", 290, 1847);
    Book book4 = new Book(4, "Robinson Crusoe", 300, "Daniel Defoe", 790, 1719);


    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
    }

    @Test
    void shouldRemoveByID() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book3, book4};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdNo() {
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}