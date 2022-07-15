package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OTM_PHONENUMBER")
@RequiredArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

	@Id
	@SequenceGenerator(name = "pnSeq", sequenceName = "regno_seq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "pnSeq", strategy = GenerationType.SEQUENCE)
	private Long regNo;
	@NonNull
	private Long phoneNo;

	@Column(length = 20)
	@NonNull
	private String provider;
	@Column(length = 20)
	@NonNull
	private String type;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person;

	public PhoneNumber() {
		System.out.println("PhoneNumber : 0-param constructor.");
	}

	@Override
	public String toString() {
		return "PhoneNumber [regNo=" + regNo + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
				+ "]";
	}

}
