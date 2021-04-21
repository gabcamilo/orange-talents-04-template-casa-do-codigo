package br.com.zupacademy.gabriela.casadocodigo.Author;

import javax.persistence.*;
import java.time.LocalDateTime;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class Author {

    @Deprecated
    public Author() {
    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @SequenceGenerator(
            name = "author_id_sequence",
            sequenceName = "author_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "author_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;


    @Column(
            name = "description",
            length = 400
    )
    private String description;

    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP",
            nullable = false
    )
    private LocalDateTime createdAt;

}