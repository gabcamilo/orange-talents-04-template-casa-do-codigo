package br.com.zupacademy.gabriela.casadocodigo.Book;

import br.com.zupacademy.gabriela.casadocodigo.Author.AuthorRepository;
import br.com.zupacademy.gabriela.casadocodigo.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    //TODO: Divide controllers in GetControllers and PostControllers so they become cohesive once again
    @GetMapping
    public ResponseEntity<List<ListBooksResponse>> list() {
        Iterable<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(ListBooksResponse.createBooksList(books));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsResponse> get(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(new BookDetailsResponse(book.get())); // 200
    }
}
