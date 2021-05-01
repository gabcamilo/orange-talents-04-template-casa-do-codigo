package br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    private Class<?> aClass;
    private String fieldName;


    //TODO: implement persistence using JPA
    @PersistenceContext
    private EntityManager manager;

    public ExistsValidator() {
    }

    @Override
    public void initialize(Exists params) {
        //gets the annotation parameters

        this.aClass = params.domainClass();
        this.fieldName = params.fieldName();

    }

    @Override
    public boolean isValid(Object argument, ConstraintValidatorContext constraintValidatorContext) {
        return manager.createQuery("select count(t) > 0 from " + aClass.getName()
                + " t where " + fieldName + "=:argument", Boolean.class)
                .setParameter("argument", argument)
                .getSingleResult();
    }
}
