package com.mycompany.spring.aop;
//Usamos librerias de AspectJ 

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order -> Prioridad de ejecucion que la dara Spring
//@Aspect -> Anotacion para indicar que sera un aspecto
//@Component -> Es manejado como un bean por Spring
@Aspect
@Component
@Order(value = 3000)
public class ProtectAnnotationAspect {

    private final Logger logger = LoggerFactory.getLogger(ProtectAnnotationAspect.class);
    private int          called = 0;

    // Have to specify fully qualified name
    // Se ejecutara antes cualquier clase publica con la anotacion con cualquiera que sean los parametros (..)
    @Before("execution(@com.mycompany.spring.aop.aspect.annotation.Protect * *(..))")
    public void protect(final JoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().getName();
        logger.info("Entering protect" + methodInformation);
        //contador de llamadas
        called++;
        try {
        } catch (Throwable ex) {
            logger.error("Exception in protect" + methodInformation, ex);
            throw ex;
        } finally {
            logger.info("Exiting protect " + methodInformation);
        }
    }

    public void resetCalled() {
        called = 0;
    }

    public int getCalled() {
        return called;
    }
}
