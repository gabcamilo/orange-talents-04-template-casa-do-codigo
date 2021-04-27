package br.com.zupacademy.gabriela.casadocodigo.Category;

import javax.validation.constraints.NotBlank;

public class CreateCategoryForm {
    public CreateCategoryForm(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category convert () {
        return new Category(this.name);
    }
}
