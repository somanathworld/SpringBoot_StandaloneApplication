package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Person;

public interface IPersonRepo extends CrudRepository<Person, Integer>{

	//@Query("SELECT p.pname, p.paddrs, ph.phoneNo, ph.provider, ph.type FROM Person p INNER JOIN p.contactDetails ph")
	//@Query("SELECT p.pname, p.paddrs, ph.phoneNo, ph.provider, ph.type FROM Person p RIGHT JOIN p.contactDetails ph")
	//@Query("SELECT p.pname, p.paddrs, ph.phoneNo, ph.provider, ph.type FROM Person p LEFT JOIN p.contactDetails ph")
	@Query("SELECT p.pname, p.paddrs, ph.phoneNo, ph.provider, ph.type FROM Person p FULL JOIN p.contactDetails ph")
	public List<Object[]> fetchDataByJoinsUsingParent();
}
