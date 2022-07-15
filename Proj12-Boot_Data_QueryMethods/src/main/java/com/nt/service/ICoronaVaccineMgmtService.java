package com.nt.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2, String comp3);
	public List<Object[]> fetchVaccineDetailsByNames(String name1, String name2);
	public List<String> fetchVaccineNamesByPriceRange(double price1, double price2);
	public Optional<CoronaVaccine> fetchVaccineByName(String vname);
	public Object fetchVaccineDataByName(String vname);
	public String fetchVaccineCountryByName(String vname);
	public long fetchVaccineCount();
	public Object fetchVaccinesAggregateDataByPriceRange(double min, double max);
	public int modifyVaccinePriceByCountry(double newPrice, String country);
	public int removalVaccinesByPriceRange(double startPrice, double endPrice);
	public int registerVaccine(String company, String country, String name, double price, int dose_count);
	public Date fetchSystemDate();
	public int createTempTable();
	public List<CoronaVaccine> searchVaccinesByPriceRange(double startPrice, double endPrice);
	public String authenticate(String user, String pwd);
	public Object[] getEmpDetailsByEno(int eno);
}
