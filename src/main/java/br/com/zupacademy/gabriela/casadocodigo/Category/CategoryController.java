package br.com.zupacademy.gabriela.casadocodigo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ProhibitsCategoryDuplicatedNameValidator prohibitsCategoryDuplicatedNameValidator;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository, ProhibitsCategoryDuplicatedNameValidator prohibitsCategoryDuplicatedNameValidator) {
        this.categoryRepository = categoryRepository;
        this.prohibitsCategoryDuplicatedNameValidator = prohibitsCategoryDuplicatedNameValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(prohibitsCategoryDuplicatedNameValidator);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CreateCategoryForm form) {
        Category category = form.convert();
        categoryRepository.save(category);
        return ResponseEntity.ok(new CategoryDto(category));
    }
}
