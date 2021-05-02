package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.gabriela.casadocodigo.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    //Controller is lo longer 100% cohesive
    @GetMapping
    public ResponseEntity<List<ListBooksResponse>> list() {
        Iterable<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(ListBooksResponse.createBooksList(books));
    }
}
