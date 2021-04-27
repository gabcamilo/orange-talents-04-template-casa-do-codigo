package br.com.zupacademy.gabriela.casadocodigo.Category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping
    public String create(@RequestBody CreateCategoryForm form) {
        return "lala";
    }
}
