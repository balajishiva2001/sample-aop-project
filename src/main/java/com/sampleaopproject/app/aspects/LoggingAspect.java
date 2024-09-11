package com.sampleaopproject.app.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution (* com.sampleaopproject.app.services.UserService.*(..))")
	public void loadAllMethods() {}
	
	@Before(value = "loadAllMethods()")
	public void loggerMethodCalledBefore(JoinPoint joinPoint) {
		LOGGER.info("Method Successfully Started: " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(value = "loadAllMethods()", returning = "result")
	public void loggerMethodCalledAfterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("Method Successfully Executed: " + joinPoint.getSignature().getName() + result);
	}
	
	@AfterThrowing(value = "loadAllMethods()", throwing = "error")
	public void loggerMethodCalledAfterThrowing(JoinPoint joinPoint, Throwable error) {
		LOGGER.info("Method Exception: " + joinPoint.getSignature().getName() + error);
	}
	
	@After(value = "loadAllMethods()")
	public void loggerMethodCalledAfter(JoinPoint joinPoint) {
		LOGGER.info("Method Successfully Completed: " + joinPoint.getSignature().getName());
	}
}
