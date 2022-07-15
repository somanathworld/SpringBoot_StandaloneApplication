package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {

	public List<EmployeeBO> getEmpsByDesgs(String desgs[])throws SQLException, Exception;

}
