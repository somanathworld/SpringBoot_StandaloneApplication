package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;
import com.nt.type.ResultView;
import com.nt.type.View;

@Service
public class CoronaVaccineMgmtService implements ICoronaVaccineMgmtService{

	@Autowired
	private ICoronaVaccineRepo repo;
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
//		return repo.findByCompany(company);
//		return repo.findByCompanyEquals(company);
		return repo.findByCompanyIs(company);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByPrice(double price) {
		return repo.findByPriceLessThan(price);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByPrice(double startPrice, double endPrice) {
		return repo.findByPriceBetween(startPrice, endPrice);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByStartName(String initChars) {
		return repo.findByNameLike(initChars);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByStatingWithName(String startLetters) {
		return repo.findByNameStartingWith(startLetters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByEndingWithName(String endLetters) {
		return repo.findByNameEndingWith(endLetters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByContainingName(String letters) {
		return repo.findByNameContaining(letters);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByCountries(List<String> countries) {
		return repo.findByCountryIn(countries);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccineByPriceAscOrderder(double price) {
		return repo.findByPriceGreaterThanOrderByPriceAsc(price);
	}
	
	@Override
	public List<ResultView> fetchVaccineByPriceAscOrder(double price) {
		return repo.findByPriceGreaterThanEqualOrderByPrice(price);
	}
	
	@Override
	public <T extends View> List<T> searchVaccineByCompany(String company, Class<T> clazz) {
		return repo.findByCompanyOrderByCompanyDesc(company, clazz);
	}
}
