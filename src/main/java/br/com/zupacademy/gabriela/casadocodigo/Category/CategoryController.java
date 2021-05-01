package br.com.zupacademy.gabriela.casadocodigo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public ResponseEntity<CreateCategoryResponse> create(@RequestBody @Valid CreateCategoryRequest form) {
        Category category = form.convert();
        categoryRepository.save(category);
        return ResponseEntity.ok(new CreateCategoryResponse(category));
    }
}
