package com.nt.service;

import java.sql.CallableStatement;
import java.sql.SQLType;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService{

	@Autowired
	private ICoronaVaccineRepo repo;
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompany(String company) {
//		return repo.searchVaccinesByCompany1(company);
		return repo.searchVaccinesByCompany2(company);
	}
	
	@Override
	public List<CoronaVaccine> fetchVaccinesByCompanies(String comp1, String comp2, String comp3) {
		return repo.searchVaccinesByCompanies(comp1, comp2, comp3);
	}
	
	@Override
	public List<Object[]> fetchVaccineDetailsByNames(String name1, String name2) {
		return repo.searchVaccineDetailsByName(name1, name2);
	}
	
	@Override
	public List<String> fetchVaccineNamesByPriceRange(double price1, double price2) {
		return repo.searchVaccineNamesByPriceRange(price1, price2);
	}
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineByName(String vname) {
		return repo.searchVaccineByName(vname);
	}
	
	@Override
	public Object fetchVaccineDataByName(String vname) {
		return repo.searchVaccineDataByName(vname);
	}
	
	@Override
	public String fetchVaccineCountryByName(String vname) {
		return repo.searchVaccineCountryByName(vname);
	}
	
	@Override
	public long fetchVaccineCount() {
		return repo.getVaccineCount();
	}
	
	@Override
	public Object fetchVaccinesAggregateDataByPriceRange(double min, double max) {
		return repo.getVaccinesAggregateDataByPriceRange(min, max);
	}
	
	@Override
	@Transactional
	public int modifyVaccinePriceByCountry(double newPrice, String country) {
		return repo.updatePriceByCountry(newPrice, country);
	}
	
	@Override
	public int removalVaccinesByPriceRange(double startPrice, double endPrice) {
		return repo.deleteVaccinesByPriceRange(startPrice, endPrice);
	}
	
	@Override
	public int registerVaccine(String company, String country, String name, double price, int dose_count) {
		return repo.insertVaccine(company, country, name, price, dose_count);
	}
	
	@Override
	public Date fetchSystemDate() {
		return repo.getSystemDate();
	}
	
	@Override
	public int createTempTable() {
		return repo.createTempTable();
	}
	
	@Override
	public List<CoronaVaccine> searchVaccinesByPriceRange(double startPrice, double endPrice) {
		//create StoredProcedure object representing our PL/SQL procedure
		StoredProcedureQuery query = 
				manager.createStoredProcedureQuery("P_GET_DETAILS_BY_PRICERANGE", CoronaVaccine.class);
		//register parameter of PL/SQL procedure
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, CoronaVaccine.class, ParameterMode.REF_CURSOR);
		//set values to parameter
		query.setParameter(1, startPrice);
		query.setParameter(2, endPrice);
		//call PL/SQL procedure
		List<CoronaVaccine> list=query.getResultList();
	    return list;		
	}
	
	@Override
	public String authenticate(String user, String pwd) {
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_AUTHENTICATION");
		//regester parameter of PL/SQL procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
		//set values to parameter
		query.setParameter(1, user);
		query.setParameter(2, pwd);
		//clas PL/SQL procedure
		String result = (String)query.getOutputParameterValue(3);
	    return result;
	}
	
	@Override
	public Object[] getEmpDetailsByEno(int eno) {
		//unwrap session
		Session ses = manager.unwrap(Session.class);
		//write plain jdbc to call PL/SQL function
		Object[] obj = ses.doReturningWork(con->{
			//create callable statement object
			CallableStatement cs = con.prepareCall("{?= call FX_GET_EMP_DETAILS(?,?,?,?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.FLOAT);
			//set value to IN param
			cs.setInt(2, eno);
			//call Pl/Sql function
			cs.execute();
			//gather result from return, out params
			Object[] objs = new Object[4];
			objs[0] = cs.getInt(1);
			objs[1] = cs.getString(3);
			objs[2] = cs.getString(4);
			objs[3] = cs.getFloat(5);
			return objs;
			});
		return obj;
	}
}
