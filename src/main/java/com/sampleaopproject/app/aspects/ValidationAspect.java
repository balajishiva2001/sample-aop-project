package com.sampleaopproject.app.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * Made it to the Order(1)
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution (* com.sampleaopproject.app.services.UserService.*(..)) && args(userId)")
	public Object validationMethodCalled(ProceedingJoinPoint proceedingJoinPoint, int userId) throws Throwable {
		
		if(userId < 0) {
			userId = -userId;
			LOGGER.info("userId corrected to positive value");
		}
		
		Object object = proceedingJoinPoint.proceed(new Object[] {userId});
		return object;
	}
}
