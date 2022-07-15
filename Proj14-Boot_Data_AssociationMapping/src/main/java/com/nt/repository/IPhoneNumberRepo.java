package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepo extends CrudRepository<PhoneNumber, Long>{

}
