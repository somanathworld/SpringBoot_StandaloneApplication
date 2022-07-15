package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CoronaVaccine;
import com.nt.type.ResultView;
import com.nt.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long>{

//	public List<CoronaVaccine> findByCompany(String company);
//	public List<CoronaVaccine> findByCompanyEquals(String company);
	public List<CoronaVaccine> findByCompanyIs(String company);
	
	public List<CoronaVaccine> findByPriceLessThan(double price);
	
	public List<CoronaVaccine> findByPriceBetween(double startPrice, double endPrice);
	
	public List<CoronaVaccine> findByNameLike(String initChars);
	
	public List<CoronaVaccine> findByNameStartingWith(String startLetters);
	
	public List<CoronaVaccine> findByNameEndingWith(String endLetters);
	
	public List<CoronaVaccine> findByNameContaining(String letters);
	
	public List<CoronaVaccine> findByCountryIn(List<String> countries);
	
	public List<CoronaVaccine> findByPriceGreaterThanOrderByPriceAsc(double price);
	
	public List<ResultView> findByPriceGreaterThanEqualOrderByPrice(double price);
	
	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> clazz);
}
