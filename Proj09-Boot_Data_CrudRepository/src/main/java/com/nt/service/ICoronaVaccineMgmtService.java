package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public String registerVaccine(CoronaVaccine vaccine);
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines);
	public long getVaccineCount();
	public boolean checkVaccineAvailabilityByRegNo(long regNo);
	public Iterable<CoronaVaccine> fetchAllDetails();
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids);
	public Optional<CoronaVaccine> fetchVaccineById(Long regNo);
	public String removeVaccineById(Long regNo);
	public String removeVaccineByObject(CoronaVaccine vaccine);
	public String removeVaccineByIds(Iterable<Long> ids);
	public String removeAllVaccines();
}
