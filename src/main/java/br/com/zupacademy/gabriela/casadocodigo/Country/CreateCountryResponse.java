package br.com.zupacademy.gabriela.casadocodigo.Country;

public class CreateCountryResponse {

    public CreateCountryResponse(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
