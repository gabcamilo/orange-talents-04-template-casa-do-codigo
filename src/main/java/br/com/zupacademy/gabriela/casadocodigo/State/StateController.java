package br.com.zupacademy.gabriela.casadocodigo.State;

import br.com.zupacademy.gabriela.casadocodigo.Country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/states")
@RestController
public class StateController {

    @Autowired
    public StateController(
            CountryRepository countryRepository,
            StateRepository stateRepository,
            ProhibitsDuplicatedStateNameInTheSameCountry prohibitsDuplicatedStateNameInTheSameCountry
    ) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
        this.prohibitsDuplicatedStateNameInTheSameCountry = prohibitsDuplicatedStateNameInTheSameCountry;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(prohibitsDuplicatedStateNameInTheSameCountry);
    }

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;
    private final ProhibitsDuplicatedStateNameInTheSameCountry prohibitsDuplicatedStateNameInTheSameCountry;

    @PostMapping
    public ResponseEntity<CreateStateResponse> create(@RequestBody @Valid CreateStateRequest request) {
        State state = request.convert(countryRepository);
        stateRepository.save(state);
        return ResponseEntity.ok(new CreateStateResponse(state));
    }
}
