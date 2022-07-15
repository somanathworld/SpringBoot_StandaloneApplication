package com.nt.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("empYml")
//@PropertySource({"com/nt/commons/emp_info.yml"})
@ConfigurationProperties(prefix = "emp.info1")
public class EmployeeInfoYml {
	private String name;
	private long id;
	private String[] nickNames;
	private List<String> teamMembers;
	private Set<String> phoneNumbers;
	private Map<String, Object> idDetails;
	private Company companyDetails;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String[] getNickNames() {
		return nickNames;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	public List<String> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<String> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public Set<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Map<String, Object> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}
	public Company getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(Company companyDetails) {
		this.companyDetails = companyDetails;
	}
	@Override
	public String toString() {
		return "EmployeeInfoYml [name=" + name + ", id=" + id + ", nickNames=" + Arrays.toString(nickNames)
				+ ", teamMembers=" + teamMembers + ", phoneNumbers=" + phoneNumbers + ", idDetails=" + idDetails
				+ ", companyDetails=" + companyDetails + "]";
	}
	
	
}

