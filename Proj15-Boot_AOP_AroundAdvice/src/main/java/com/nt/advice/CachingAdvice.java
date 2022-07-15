package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//@Order(1)
public class CachingAdvice {

	private Map<String, Object> cacheMap = new HashMap<>();
	
	
//	@Pointcut(value = "execution(double com.nt.service.IBankService.calc*(..))")
	public void myPtc() {
		
	}

//	@Around(value = "myPtc()")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		//prepare key
		String key = pjp.getSignature()+Arrays.toString(pjp.getArgs());
		Object retVal = null;
		//check in cache
		if(!cacheMap.containsKey(key)) {
			retVal = pjp.proceed();
			cacheMap.put(key, retVal);	
			System.out.println("From target method.");
		}else {
			System.out.println("From cache.");
			retVal = cacheMap.get(key);
		}
		return retVal;
	}
	
}
