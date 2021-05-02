package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.Author;
import br.com.zupacademy.gabriela.casadocodigo.Category.Category;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookDetailsResponse {

    public BookDetailsResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();

        Author author = book.getAuthor();

        this.author_name = author.getName();
        this.author_description = author.getDescription();
    }

    private Long id;
    private String title;
    private BigDecimal price;
    private Integer numberOfPages;
    private String isbn;

    private String author_name;
    private String author_description;

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

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_description() {
        return author_description;
    }
}
