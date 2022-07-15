package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.CoronaVaccine;
import com.nt.repo.ICoronaVaccineRepo;

@Service
public class CoronaVaccineMgmtServiceImpl implements ICoronaVaccineMgmtService{

	@Autowired
	private ICoronaVaccineRepo vaccineRepo;
	
	@Override
	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, properties); 
		return vaccineRepo.findAll(sort);
	}
	
	@Override
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc?Direction.ASC : Direction.DESC, properties);
		Page<CoronaVaccine> page = vaccineRepo.findAll(pageable);
		return page.getContent();
	}
	
	@Override
	public void fetchDetailsByPagination(int pageSize) {
		long count = vaccineRepo.count();
		long pageCount = count/pageSize;
		pageCount = count % pageSize == 0 ? pageCount : ++pageCount;
		
		for(int i = 0; i<pageCount; ++i) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<CoronaVaccine> page = vaccineRepo.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("----------"+(i+1)+" of "+page.getTotalPages()+" -----------");
		}
	}
}
