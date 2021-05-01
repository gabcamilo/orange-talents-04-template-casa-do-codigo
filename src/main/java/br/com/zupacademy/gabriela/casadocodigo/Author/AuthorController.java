package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<CreteAuthorResponse> create(@RequestBody @Valid CreateAuthorRequest form) {
        Author author = form.convert();
        authorRepository.save(author);
        return ResponseEntity.ok(new CreteAuthorResponse(author));
    }
}
