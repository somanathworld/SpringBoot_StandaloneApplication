package com.nt.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {

//	@Query("FROM CoronaVaccine WHERE company=?1")
//	@Query("FROM com.nt.entity.CoronaVaccine WHERE company=?1")
//	@Query("FROM CoronaVaccine as cv WHERE cv.company=?1")
//	@Query("FROM CoronaVaccine as cv WHERE cv.company=?")
	@Query("FROM CoronaVaccine as cv WHERE cv.company=:company")
	public List<CoronaVaccine> searchVaccinesByCompany1(String company);

	@Query("FROM CoronaVaccine as cv WHERE cv.company=:comp")
	public List<CoronaVaccine> searchVaccinesByCompany2(@Param("comp")String company);
	
	//entity query
	@Query("FROM CoronaVaccine WHERE company IN(:comp1, :comp2, :comp3)")
	public List<CoronaVaccine> searchVaccinesByCompanies(String comp1, String comp2, String comp3);

	//scalar query mulitple cols
	@Query("SELECT name, company, price FROM CoronaVaccine WHERE name IN(:name1, :name2)")
	public List<Object[]> searchVaccineDetailsByName(String name1, String name2);

	
	//scalar query single col
	@Query("SELECT name FROM CoronaVaccine WHERE price BETWEEN :price1 AND :price2")
	public List<String> searchVaccineNamesByPriceRange(double price1, double price2);
	
	//entity query
	@Query("FROM CoronaVaccine WHERE name = :vname")
	public Optional<CoronaVaccine> searchVaccineByName(String vname);

	//scalar query mulitple cols
	@Query("SELECT name, company, price FROM CoronaVaccine WHERE name = :vname")
	public Object searchVaccineDataByName(String vname);

	//scalar query mulitple cols
	@Query("SELECT country FROM CoronaVaccine WHERE name = :vname")
	public String searchVaccineCountryByName(String vname);
	
	//aggregate operation
	@Query("SELECT COUNT(*) FROM CoronaVaccine")
	public long getVaccineCount();
	
	@Query("SELECT COUNT(*), MAX(price), MIN(price) FROM CoronaVaccine WHERE price BETWEEN :min AND :max")
	public Object getVaccinesAggregateDataByPriceRange(double min, double max);
	
	//non-select operations
	@Query("UPDATE CoronaVaccine SET price = :newPrice WHERE country=:country")
	@Modifying
	public int updatePriceByCountry(double newPrice, String country);
	
	@Transactional
	@Query("DELETE FROM CoronaVaccine WHERE price BETWEEN :startPrice AND :endPrice")
	@Modifying
	public int deleteVaccinesByPriceRange(double startPrice, double endPrice);
	
	
	@Transactional
	@Query(value = "INSERT INTO CORONA_VACCINE_TAB VALUES(HIBERNATE_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?)", nativeQuery = true)
	@Modifying
	public int insertVaccine(String company, String country, String name, double price, int dose_count);
	
	@Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery = true)
	public Date getSystemDate();
	
	@Transactional
	@Modifying
	@Query(value = "CREATE TABLE TEMP(COL1 NUMBER(5), COL2 VARCHAR2(20))", nativeQuery = true)
	public int createTempTable();
}
