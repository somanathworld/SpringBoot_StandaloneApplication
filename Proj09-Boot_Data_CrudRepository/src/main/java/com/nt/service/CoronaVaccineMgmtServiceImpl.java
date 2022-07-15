package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService{

	@Autowired
	private ICoronaVaccineRepo vaccineRepo;
	
	@Override
	public String registerVaccine(CoronaVaccine vaccine) {
		System.out.println("Inmemory Proxy class name : "+vaccineRepo.getClass().getName());
		
		CoronaVaccine savedVaccine = null;
		if(vaccine != null) 
			savedVaccine = vaccineRepo.save(vaccine);
		return savedVaccine != null ? 
				"Vaccine registered successfully with "+savedVaccine.getRegNo()+" . "
				: "Vaccine registration failed . ";						
		
	}
	
	@Override
	public Iterable<CoronaVaccine> registerInBatch(Iterable<CoronaVaccine> vaccines) {
		if(vaccines != null)
			return vaccineRepo.saveAll(vaccines);
		else
			throw new IllegalArgumentException("Batch Inserstion not done. ");
	}
	
	@Override
	public long getVaccineCount() {
		return vaccineRepo.count();
	}
	
	@Override
	public boolean checkVaccineAvailabilityByRegNo(long regNo) {
		return vaccineRepo.existsById(regNo);
	}
	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetails() {
		return vaccineRepo.findAll();
	}
	
	@Override
	public Iterable<CoronaVaccine> fetchAllDetailsById(List<Long> ids) {
		return vaccineRepo.findAllById(ids);
	}
	
	@Override
	public Optional<CoronaVaccine> fetchVaccineById(Long regNo) {
		return vaccineRepo.findById(regNo);
	}
	
	@Override
	public String removeVaccineById(Long regNo) {
		Optional<CoronaVaccine> vaccine = vaccineRepo.findById(regNo);
		if(vaccine.isPresent()) {
			vaccineRepo.deleteById(regNo);
			return "Record deleted having id : "+regNo;
		}else {
			return "Record not found for deletion. ";
		}
	}
	
	@Override
	public String removeVaccineByObject(CoronaVaccine vaccine) {
		Optional<CoronaVaccine> opt = vaccineRepo.findById(vaccine.getRegNo());
		if(opt.isPresent()) {
			vaccineRepo.delete(vaccine);
			return "Record deleted having id : "+vaccine.getRegNo();
		}else {
			return "Record not found for deletion. ";
		}
	}
	
	@Override
	public String removeVaccineByIds(Iterable<Long> ids) {
		
		Iterable<CoronaVaccine> vaccines = vaccineRepo.findAllById(ids);
		int count = ((List)vaccines).size();
		if( ((List)vaccines).size() == ((List)ids).size() ) {
			vaccineRepo.deleteAllById(ids);
			return count + " no. of records are deleted. ";
		}else {
			return "Problem in deleting records. ";
		}
	}
	
	@Override
	public String removeAllVaccines() {
		long count = getVaccineCount();
		if(count != 0 ) {
			vaccineRepo.deleteAll();
			return count + " no. of records are deleted. ";
		}else {
			return "Table is empty to deleted records. ";
		}
	}
}
