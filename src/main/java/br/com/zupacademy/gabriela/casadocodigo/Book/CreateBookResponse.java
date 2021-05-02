package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.Author;
import br.com.zupacademy.gabriela.casadocodigo.Category.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateBookResponse {
    public CreateBookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.publishingDate = book.getPublishingDate();
        this.category = book.getCategory();
        this.author = book.getAuthor();
    }

    private Long id;
    private String title;
    private BigDecimal price;
    private Integer numberOfPages;
    private String isbn;
    private LocalDate publishingDate;

    //TODO: Make non-entity responses to author and category attributes
    private Category category;
    private Author author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
