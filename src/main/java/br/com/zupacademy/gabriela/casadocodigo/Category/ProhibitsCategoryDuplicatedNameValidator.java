package br.com.zupacademy.gabriela.casadocodigo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProhibitsCategoryDuplicatedNameValidator implements Validator {

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProhibitsCategoryDuplicatedNameValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // Defines in which parameter type we must apply the validation
        return CreateCategoryForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        CreateCategoryForm requestForm = (CreateCategoryForm) target;

        Optional<Category> optionalCategory = categoryRepository.findByName(requestForm.getName());

        if (optionalCategory.isPresent()) {
            errors.rejectValue(
                    "name",
                    null,
                    "The category name must be unique. There is already a category with the name: " + requestForm.getName()
            );
        }

    }
}
