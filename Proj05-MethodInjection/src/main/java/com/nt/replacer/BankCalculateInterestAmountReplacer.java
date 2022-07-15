package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class BankCalculateInterestAmountReplacer implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		float pAmnt = (float)args[0];
		float rate = (float)args[1];
		float time = (float)args[2];
		return ((pAmnt * rate * time)/100);
	}
}
