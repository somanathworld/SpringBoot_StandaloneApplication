package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO> getEmpsByDesgs(String cond) throws Exception;
}
