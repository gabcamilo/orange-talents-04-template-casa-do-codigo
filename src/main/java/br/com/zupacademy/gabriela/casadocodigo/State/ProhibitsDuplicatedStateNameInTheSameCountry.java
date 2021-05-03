package br.com.zupacademy.gabriela.casadocodigo.State;

import br.com.zupacademy.gabriela.casadocodigo.Country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProhibitsDuplicatedStateNameInTheSameCountry implements Validator {

    @Autowired
    public ProhibitsDuplicatedStateNameInTheSameCountry(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    private StateRepository stateRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CreateStateRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CreateStateRequest requestForm = (CreateStateRequest) target;
        Country country = new Country(requestForm.getCountry_id());

        List<State> statesAlreadyRegistered = stateRepository.findByNameAndCountry(requestForm.getName(), country);
        if(statesAlreadyRegistered.size() > 0) {
            errors.rejectValue(
                    "name",
                    "",
                    "There is already a state named " + requestForm.getName() + " in this country"
            );
        }

    }
}
