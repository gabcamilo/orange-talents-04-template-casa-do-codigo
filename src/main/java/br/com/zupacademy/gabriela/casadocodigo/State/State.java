package br.com.zupacademy.gabriela.casadocodigo.State;

import br.com.zupacademy.gabriela.casadocodigo.Country.Country;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
public class State {

    public State(String name, Country country) {
        Name = name;
        this.country = country;
    }

    @Deprecated
    public State() {
    }

    @Id
    @SequenceGenerator(name = "country_id_unique", sequenceName = "country_id_unique", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "country_id_unique")
    private Long id;
    private String Name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Country country;

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Country getCountry() {
        return country;
    }

    public Long getCountryId() {
        return this.country.getId();
    }

    public String getCountryName() {
        return this.country.getName();
    }
}
