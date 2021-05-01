package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.Author;
import br.com.zupacademy.gabriela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.gabriela.casadocodigo.Category.Category;
import br.com.zupacademy.gabriela.casadocodigo.Category.CategoryRepository;
import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.Exists;
import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonFormat.*;

public class CreateBookRequest {

    public CreateBookRequest(
            String title,
            String synopsis,
            String summary,
            BigDecimal price,
            Integer numberOfPages,
            String isbn,
            LocalDate publishingDate,
            Long category_id,
            Long author_id
    ) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publishingDate = publishingDate;
        this.category_id = category_id;
        this.author_id = author_id;
    }


    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotBlank
    @Size(max = 500)
    private String synopsis;

    private String summary;

    @DecimalMin(value = "20")
    private BigDecimal price;

    @Min(100)
    private Integer numberOfPages;

    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private LocalDate publishingDate;

    @Exists(domainClass = Category.class)
    private Long category_id;

    @Exists(domainClass = Category.class)
    private Long author_id;

    public Book convert(CategoryRepository categoryRepository, AuthorRepository authorRepository) {

        Category category = categoryRepository.findById(category_id).get();
        Author author = authorRepository.findById(author_id).get();

        return new Book(title, synopsis, summary, price, numberOfPages, isbn, publishingDate, category, author);
    }
}
