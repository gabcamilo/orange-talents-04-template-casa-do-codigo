package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.Author;
import br.com.zupacademy.gabriela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.gabriela.casadocodigo.Category.Category;
import br.com.zupacademy.gabriela.casadocodigo.Category.CategoryRepository;
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

    //TODO: exists validator
    private Long category_id;
    private Long author_id;

    public Book convert(CategoryRepository categoryRepository, AuthorRepository authorRepository) throws Exception {

        Optional<Category> optionalCategory = categoryRepository.findById(category_id);
        Optional<Author> optionalAuthor = authorRepository.findById(author_id);

        //TODO: replace this code logic for a custom generic validator e.g. @Exists
        if (optionalAuthor.isEmpty()) {
            throw new Exception("This author doesn't exist");
        }

        if (optionalCategory.isEmpty()) {
            throw new Exception("This category doesn't exist");
        }

        return new Book(title, synopsis, summary, price, numberOfPages, isbn, publishingDate, optionalCategory.get(), optionalAuthor.get());
    }
}
