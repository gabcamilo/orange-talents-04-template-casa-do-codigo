package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.Author;
import br.com.zupacademy.gabriela.casadocodigo.Category.Category;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "book",
        uniqueConstraints = {
                @UniqueConstraint(name = "book_title_unique", columnNames = "title"),
                @UniqueConstraint(name = "book_isbn_unique", columnNames = "isbn")
        })
public class Book {
    public Book(String title, String synopsis, String summary, BigDecimal price, Integer numberOfPages, String isbn, LocalDate publishingDate, Category category, Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishingDate = publishingDate;
        this.category = category;
        this.author = author;
    }

    @Deprecated
    public Book() {
    }

    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "book_id_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;


    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    @Column(
            name = "synopsis",
            nullable = false,
            length = 500
    )
    private String synopsis;

    @Column(
            name = "summary",
            columnDefinition = "TEXT"
    )
    private String summary;

    @DecimalMin(value = "20")
    @Column(
            name = "price",
            nullable = false
    )
    private BigDecimal price;

    @Min(100)
    @Column(
            name = "number_of_pages",
            nullable = false
    )
    private Integer numberOfPages;

    private String isbn;
    private LocalDate publishingDate;

    @ManyToOne(optional = false)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "category_book_fk"
            )

    )
    private Category category;


    @ManyToOne(optional = false)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "author_book_fk"
            )

    )
    private Author author;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getSynopsis() {
        return synopsis;
    }


    public String getSummary() {
        return summary;
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
