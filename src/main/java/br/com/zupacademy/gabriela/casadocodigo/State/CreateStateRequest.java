package br.com.zupacademy.gabriela.casadocodigo.State;

import br.com.zupacademy.gabriela.casadocodigo.Country.Country;
import br.com.zupacademy.gabriela.casadocodigo.Country.CountryRepository;
import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.Exists;
import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateStateRequest {
    public CreateStateRequest(String name, Long country_id) {
        this.name = name;
        this.country_id = country_id;
    }

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name")
    private String name;

    @NotNull
    @Exists(domainClass = Country.class)
    private Long country_id;

    public State convert(CountryRepository countryRepository) {
        Country country = countryRepository.findById(country_id).get();
        return new State(name, country);
    }
}
