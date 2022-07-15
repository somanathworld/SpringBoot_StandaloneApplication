package com.nt.advice;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.exception.InternalProblemException;

@Component
@Aspect
@Order(5)
public class CommonExceptionGrapher_Logger {

	@AfterThrowing(pointcut = "execution(double com.nt.service.ShoppingStore.calc*(..))", throwing = "iae")
	public void exceptionLogger(JoinPoint jp, IllegalArgumentException iae) throws IOException, InternalProblemException {
		//Exception logger
		Writer writer = new FileWriter("expLogger.txt", true);
		writer.write(jp.getSignature()+" with args : "+Arrays.toString(jp.getArgs())+" has raised exception : "+iae+"\n");
		writer.flush();
		writer.close();
		//Exception grapher
		throw new InternalProblemException(jp.getSignature()+" with args "+Arrays.toString(jp.getArgs())+"has raised exception : "+iae.getMessage());
	}
}
