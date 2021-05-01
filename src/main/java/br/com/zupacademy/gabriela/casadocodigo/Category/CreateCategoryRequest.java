package br.com.zupacademy.gabriela.casadocodigo.Category;

import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CreateCategoryRequest {
    public CreateCategoryRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Category convert () {
        return new Category(this.name);
    }
}
