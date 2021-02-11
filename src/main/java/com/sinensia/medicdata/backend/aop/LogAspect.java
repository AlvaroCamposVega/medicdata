package com.sinensia.medicdata.backend.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@Before("execution(* com.sinensia.medicdata.backend.presentation.restcontrollers.UsuarioController.getAll())")
	public void getAll() {
		logger.info("Mostramos todos los usuarios");
	}

	@Before("execution(* com.sinensia.medicdata.backend.business.services.impl..*(..))")
	public void businessInterceptor(JoinPoint joinPoint) {
		logger.info("Entramos en el metodo de Business: " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.sinensia.medicdata.backend.presentation.restcontrollers..*(..))")
	public void restControllerInterceptor(JoinPoint joinPoint) {
		logger.info("Entramos en el metodo de restController: " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.sinensia.medicdata.backend.integration.repositories..*(..))")
	public void integrationInterceptor(JoinPoint joinPoint) {
		logger.info("Entramos en el metodo de Integration: " + joinPoint.getSignature().getName());
	}
}
