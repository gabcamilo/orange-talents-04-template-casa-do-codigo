package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateAuthorForm {

    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty @Email
    private String email;

    @Length(max = 400)
    private String description;

    public Author convert(){
        return new Author(name, email, description);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
