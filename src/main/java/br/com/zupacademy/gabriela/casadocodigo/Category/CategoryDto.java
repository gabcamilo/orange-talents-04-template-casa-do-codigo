package br.com.zupacademy.gabriela.casadocodigo.Category;

public class CategoryDto {
    private final Long id;
    private final String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
