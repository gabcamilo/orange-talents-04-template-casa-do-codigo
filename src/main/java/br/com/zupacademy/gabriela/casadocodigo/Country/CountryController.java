package br.com.zupacademy.gabriela.casadocodigo.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    private final CountryRepository countryRepository;

    @PostMapping
    ResponseEntity<CreateCountryResponse> create (@RequestBody @Valid CreateCountryRequest request) {
        Country country = request.convert();
        countryRepository.save(country);
        return ResponseEntity.ok(new CreateCountryResponse(country));
    }
}
