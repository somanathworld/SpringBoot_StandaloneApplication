package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//@Order(2)
public class PerformanceMonitoringAdvice {

//	@Around(value = "execution(double com.nt.service.IBankService.*(..))")
	public Object performance(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("PerformanceMonitoringAdvice.performance()(before entering.....)");
		//pre logic
		long start = System.currentTimeMillis();
		Object retVal = pjp.proceed(); //call target
		//post logic
		long end = System.currentTimeMillis();
		System.out.println("PerformanceMonitoringAdvice.performance()(before entering.....)");
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms.");
		
		return retVal;
	}
}
