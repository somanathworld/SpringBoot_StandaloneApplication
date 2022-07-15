package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineServiceMgmt {

	@Autowired
	private ICoronaVaccineRepo vaccineRepo;
	
	@Override
	public List<CoronaVaccine> searchVaccinesByGivenData(CoronaVaccine vaccine, boolean ascOrder,
			String... properties) {
		Example<CoronaVaccine> example = Example.of(vaccine);
		Sort sort = Sort.by(ascOrder?Direction.ASC : Direction.DESC, properties);
		return vaccineRepo.findAll(example, sort);
	}
}
