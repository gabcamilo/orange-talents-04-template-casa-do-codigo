package br.com.zupacademy.gabriela.casadocodigo.State;


public class CreateStateResponse {

    public CreateStateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country_id = state.getCountryId();
        this.country_name = state.getCountryName();
    }

    private Long id;
    private String name;
    private Long country_id;
    private String country_name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public String getCountry_name() {
        return country_name;
    }
}
