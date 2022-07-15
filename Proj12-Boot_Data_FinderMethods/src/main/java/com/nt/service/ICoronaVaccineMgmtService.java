package com.nt.service;

import java.util.List;

import com.nt.entity.CoronaVaccine;
import com.nt.type.ResultView;
import com.nt.type.View;

public interface ICoronaVaccineMgmtService {
	
	public List<CoronaVaccine> fetchVaccinesByCompany(String company);
	public List<CoronaVaccine> fetchVaccinesByPrice(double price);
	public List<CoronaVaccine> fetchVaccineByPrice(double startPrice, double endPrice);
	public List<CoronaVaccine> fetchVaccineByStartName(String initChars);
	public List<CoronaVaccine> fetchVaccineByStatingWithName(String startLetters);
	public List<CoronaVaccine> fetchVaccineByEndingWithName(String endLetters);
	public List<CoronaVaccine> fetchVaccineByContainingName(String letters);
	public List<CoronaVaccine> fetchVaccineByCountries(List<String> countries);
	public List<CoronaVaccine> fetchVaccineByPriceAscOrderder(double price);
	public List<ResultView> fetchVaccineByPriceAscOrder(double price);
	public <T extends View> List<T> searchVaccineByCompany(String company, Class<T> clazz);
}
