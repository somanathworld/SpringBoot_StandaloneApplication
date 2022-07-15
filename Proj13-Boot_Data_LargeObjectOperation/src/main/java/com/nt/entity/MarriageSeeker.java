package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "marriage_seeker_tab")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker {

	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	@Column(length = 20)
	private String addrs;
	@NonNull
	@Lob
	private byte[] photo;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	@Lob
	private char[] biodata;

	@NonNull
	private Boolean indian;
}
