package br.com.zupacademy.gabriela.casadocodigo.Country;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "country_name_unique", columnNames = "name"))
public class Country {

    public Country(String name) {
        this.name = name;
    }

    @Deprecated
    public Country() {
    }

    @Id
    @SequenceGenerator(
            name = "country_id_sequence",
            sequenceName = "country_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "country_id_sequence")
    @Column(updatable = false)
    private Long id;

    private String name;

    public Country(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
