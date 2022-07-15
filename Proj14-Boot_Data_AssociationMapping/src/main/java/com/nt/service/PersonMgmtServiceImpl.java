package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepo;
import com.nt.repository.IPhoneNumberRepo;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonRepo personRepo;
	
	@Autowired
	private IPhoneNumberRepo phoneRepo;
	
	@Override
	public String savePerson(Person per) {
		int idVal = personRepo.save(per).getPid();
		return "Person and his PhoneNumbers are saved with id value : "+idVal;
	}
	
	@Override
	public String savePhoneNumbers(Iterable<PhoneNumber> phoneSet) {
		for(PhoneNumber number : phoneSet) {
			phoneRepo.save(number);
		}
		return ((Set<PhoneNumber>)phoneSet).size()+" no. of phoneNumbers are saved.";
	}
	
	
	@Override
	public Iterable<Person> fetchByPerson() {
		return personRepo.findAll();
	}
	
	@Override
	public Iterable<PhoneNumber> fetchByPhoneNumber() {
		return phoneRepo.findAll();
	}
	
	@Override
	public String deleteByPerson(int personId) {
		Optional<Person> opt = personRepo.findById(personId);
		if(opt.isPresent()) {
			personRepo.deleteById(personId);
			return "Person and his phone numbers are deleted. ";
		}else {
			return "Record not found.";
		}
	}
	
	@Override
	public String deleteAllPhoneNumbersOfAPerson(int personId) {
		Optional<Person> opt = personRepo.findById(personId);
		if(opt.isPresent()) {
			Set<PhoneNumber> phoneSet = opt.get().getContactDetails();
			for(PhoneNumber num : phoneSet) {
				num.setPerson(null);
			}
			phoneRepo.deleteAll(phoneSet);
			return phoneSet.size()+" Phonenumbers of "+personId+" Person are deleted.";
		}else {
			return "Record not found.";
		}
	}
	
	@Override
	public List<Object[]> getDataByJoinsUsingParent() {
		return personRepo.fetchDataByJoinsUsingParent();
	}
}
