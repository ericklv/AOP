package com.mycompany.spring.validation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mycompany.spring.aop.AspectConfig;
import com.mycompany.spring.validation.CustomerService;
import com.mycompany.spring.validation.ValidationConfig;

@ContextConfiguration(classes = { ValidationConfig.class, AspectConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;
    
    //Prueba cuando los argumentos son invalidos
    
    @Test
    public void throwsViolationExceptionWhenAllArgumentsInvalid() {
        try {
            service.createUser(null, null, null);
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 3, true);
        }
    }
    
    
    
    //Prueba cuando 2 argumentos son invalidos
    /*
    @Test
    public void throwsViolationExceptionWhen2ArgumentsInvalid() {
        try {
            service.createUser(null, null, "valid");
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 2, true);
        }
    }
    */
    
    //Prueba con Excepcion al Usar un Email invalido
    /*
    @Test
    public void throwsViolationExceptionWhenEmailInvalidArgumentsInvalid() {
        try {
            service.createUser("invalid_email", "valid", "valid");
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 1, true);
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            assertEquals("not a well-formed email address", violations.iterator().next().getMessage());
        }
    }
    */
    
    //Prueba con Excepcion, el aspecto se encarga de atrapar la excepcion
    /*
    @Test
    public void throwsViolationExceptionWhenReturnValueTooLong() {
        try {
            service.createUser("user@domain.com", "too_long_username", "valid");
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 1, true);
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            assertEquals("length must be between 3 and 5", violations.iterator().next().getMessage());
        }
    }*/
    
    //Prueba con excepcion en la lectura 
    /*
    @Test
    public void throwsViolationExceptionWhenCustomerRead() {
        try {
            service.readUser(null);
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 1, true);
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            assertEquals("may not be empty", violations.iterator().next().getMessage());
        }
    }
    */
    //Test Creando Usuario
    @Test
    public void createsUser() {
        try {
        	System.out.println("Creando usuario");
            service.createUser("user@domain.com", "valid", "valid");
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 1, true);
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            assertEquals("may not be empty", violations.iterator().next().getMessage());
        }
    }
}