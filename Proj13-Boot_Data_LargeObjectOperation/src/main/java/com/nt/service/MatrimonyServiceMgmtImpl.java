package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repo.IMatrimonyRepo;

@Service("matrimonyService")
public class MatrimonyServiceMgmtImpl implements IMatrimonyServiceMgmt{

	@Autowired
	private IMatrimonyRepo repo;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		return "Marriage seeker info is saved with id value : "+repo.save(seeker).getId();
	}
	
	@Override
	public Optional<MarriageSeeker> searchSeekerById(Long id){
		return repo.findById(id);
	}
}
