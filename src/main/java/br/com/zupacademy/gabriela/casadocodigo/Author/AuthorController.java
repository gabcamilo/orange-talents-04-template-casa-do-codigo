package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final ProhibitsAuthorDuplicatedEmailValidator prohibitsAuthorDuplicatedEmailValidator;

    @Autowired
    AuthorController(AuthorRepository authorRepository, ProhibitsAuthorDuplicatedEmailValidator prohibitsAuthorDuplicatedEmailValidator) {
        this.authorRepository = authorRepository;
        this.prohibitsAuthorDuplicatedEmailValidator = prohibitsAuthorDuplicatedEmailValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(prohibitsAuthorDuplicatedEmailValidator);
    }

    @PostMapping
    public ResponseEntity<AuthorDto> create(@RequestBody @Valid CreateAuthorForm form) {
        Author author = form.convert();
        authorRepository.save(author);
        return ResponseEntity.ok(new AuthorDto(author));
    }
}
