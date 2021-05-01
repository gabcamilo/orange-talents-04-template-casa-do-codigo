package br.com.zupacademy.gabriela.casadocodigo.Util.CustomValidation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String fieldName;
    private Class<?> aClass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        fieldName = params.fieldName();
        aClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from " + aClass.getName() + " where " + fieldName + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um " + aClass + "com o atributo " + fieldName + " = " + value);

        return list.isEmpty();
    }
}
