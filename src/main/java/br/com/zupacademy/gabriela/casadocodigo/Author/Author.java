package br.com.zupacademy.gabriela.casadocodigo.Author;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


import static javax.persistence.GenerationType.SEQUENCE;

@Validated
@Entity
public class Author {

    @Deprecated
    public Author() {
    }

    public Author(String name, String email, String description) {
        this.name = name;
        this.email = email.toLowerCase();
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @SequenceGenerator(
            name = "author_id_sequence",
            sequenceName = "author_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "author_id_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @NotEmpty
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "description", length = 400)
    private String description;

    @NotNull
    @Column(
            name = "created_at",
            columnDefinition = "TIMESTAMP",
            nullable = false
    )
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
