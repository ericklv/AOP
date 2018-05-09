package com.mycompany.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
 *
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackageClasses = { TraceAnnotationAspect.class, ProtectAnnotationAspect.class })
public class AspectConfig {

}
