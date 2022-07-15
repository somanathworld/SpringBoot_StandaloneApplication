package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.MarriageSeeker;

public interface IMatrimonyRepo extends CrudRepository<MarriageSeeker, Long>{

}
