package br.com.zupacademy.gabriela.casadocodigo.Category;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CreateCategoryForm {
    public CreateCategoryForm( @JsonProperty("name") String name) {
        this.name = name;
    }

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public Category convert () {
        return new Category(this.name);
    }
}
