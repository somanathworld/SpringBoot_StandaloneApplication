package com.nt.service;

import java.sql.SQLException;
import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	
	public List<EmployeeDTO> fetchEmpsByDesgs(String desgs[]) throws SQLException, Exception;
}
