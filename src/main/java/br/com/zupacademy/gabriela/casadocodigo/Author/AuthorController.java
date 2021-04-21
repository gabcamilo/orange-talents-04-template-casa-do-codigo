package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<AuthorDto> create(@RequestBody @Valid CreateAuthorForm form) {
        Author author = form.convert();
        authorRepository.save(author);
        AuthorDto authorDto = new AuthorDto(author);
        System.out.println(authorDto);
        return ResponseEntity.ok(new AuthorDto(author));
    }
}
