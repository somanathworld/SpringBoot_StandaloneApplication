package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("companyV")
public class CompanyDeatilsValue {

	@Value("${org.nit.name}")
	private String name;
	@Value("${org.nit.type}")
	private String type;
	@Value("${org.nit.location}")
	private String location;
	@Override
	public String toString() {
		return "CompanyDeatilsValue [name=" + name + ", type=" + type + ", location=" + location + "]";
	}
	
}
