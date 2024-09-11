package com.sampleaopproject.app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);
	
	@Around("execution (* com.sampleaopproject.app.services.UserService.*(..))")
	public Object performanceMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object object = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		LOGGER.info("Execution Time: "+ String.valueOf(end-start)+" ms");
		return object;
	}
}
