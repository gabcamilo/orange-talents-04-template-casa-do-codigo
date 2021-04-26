package br.com.zupacademy.gabriela.casadocodigo.Author;

import javax.validation.constraints.*;

public class CreateAuthorForm {

    public CreateAuthorForm(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @Size(max = 400)
    private String description;

    public Author convert() {
        return new Author(name.trim(), email.toLowerCase().trim(), description.trim());
    }

    public String getEmail() {
        return email;
    }
}
