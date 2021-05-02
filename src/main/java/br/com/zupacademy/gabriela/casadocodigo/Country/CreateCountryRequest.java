package br.com.zupacademy.gabriela.casadocodigo.Country;

import br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CreateCountryRequest {

    public CreateCountryRequest(@JsonProperty(value = "name") String name) {
        this.name = name;
    }

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public Country convert() {
        return new Country(this.name);
    }
}
