package br.com.zupacademy.gabriela.casadocodigo.State;

import br.com.zupacademy.gabriela.casadocodigo.Country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/states")
@RestController
public class StateController {

    @Autowired
    public StateController(CountryRepository countryRepository, StateRepository stateRepository) {
        this.countryRepository = countryRepository;
        this.stateRepository = stateRepository;
    }

    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    @PostMapping
    public ResponseEntity<CreateStateResponse> create(@RequestBody @Valid CreateStateRequest request) {
        State state = request.convert(countryRepository);
        //TODO: Validate two equal states in the same country
        stateRepository.save(state);
        return ResponseEntity.ok(new CreateStateResponse(state));
    }
}
