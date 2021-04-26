package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProhibitsAuthorDuplicatedEmailValidator implements Validator {

    private final AuthorRepository authorRepository;

    @Autowired
    public ProhibitsAuthorDuplicatedEmailValidator(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // Defines in which parameter type we must apply the validation
        return CreateAuthorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CreateAuthorForm requestForm  = (CreateAuthorForm) target;
        Optional<Author> optionalAuthor = authorRepository.findByEmail(requestForm.getEmail());
        if (optionalAuthor.isPresent()) {
            errors.rejectValue(
                    "email",
                    null,
                    "The author's email must be unique. There is already an author with this email:" + requestForm.getEmail()
            );
        }
    }
}
