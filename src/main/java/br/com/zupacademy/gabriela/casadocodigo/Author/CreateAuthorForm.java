package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class CreateAuthorForm {

    public CreateAuthorForm(String name, String email, String description) {
        this.name = name.trim();
        this.email = email.trim().toLowerCase();
        this.description = description.trim();
    }

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Length(max = 400)
    private String description;

    public Author convert() {
        return new Author(name, email, description);
    }

    public String getEmail() {
        return email;
    }
}
