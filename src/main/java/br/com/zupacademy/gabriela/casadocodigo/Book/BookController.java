package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.gabriela.casadocodigo.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<CreateBookResponse> create(@RequestBody @Valid CreateBookRequest form) {
        Book book = form.convert(categoryRepository, authorRepository);
        bookRepository.save(book);
        return ResponseEntity.ok(new CreateBookResponse(book));
    }
}
