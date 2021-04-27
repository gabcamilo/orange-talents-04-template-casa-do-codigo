package br.com.zupacademy.gabriela.casadocodigo.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.SEQUENCE;

@Table(
        name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "author_name_unique", columnNames = "name")
        })
@Entity
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_id_sequence",
            sequenceName = "category_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "category_id_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    private String name;

    public Category(@NotBlank String name) {
        this.name = name;
    }
    
    @Deprecated
    public Category () {
        
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
