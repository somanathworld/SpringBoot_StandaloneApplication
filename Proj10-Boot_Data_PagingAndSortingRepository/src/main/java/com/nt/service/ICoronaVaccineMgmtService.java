package com.nt.service;

import com.nt.entity.CoronaVaccine;

public interface ICoronaVaccineMgmtService {

	public Iterable<CoronaVaccine> fetchDetails(boolean asc, String... properties);
	public Iterable<CoronaVaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties);
	public void fetchDetailsByPagination(int pageSize);
}
