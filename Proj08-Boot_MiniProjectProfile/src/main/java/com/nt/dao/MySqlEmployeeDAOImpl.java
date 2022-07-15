package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("mysqlDAO")
@Profile(value = {"dev", "test"})
public class MySqlEmployeeDAOImpl implements IEmployeeDAO{

	@Autowired
	private DataSource ds;
	
	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP  WHERE JOB IN";
	
	@Override
	public List<EmployeeBO> getEmpsByDesgs(String cond) throws Exception {
		List<EmployeeBO> listBO = new ArrayList<EmployeeBO>();
		try {
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(GET_EMPS_BY_DESGS+cond);
			while(rs.next()) {
				EmployeeBO empBo = new EmployeeBO();
				empBo.setEmpNo(rs.getInt(1));
				empBo.setEname(rs.getString(2));
				empBo.setJob(rs.getString(3));
				empBo.setSal(rs.getDouble(4));
				empBo.setDeptNo(rs.getInt(5));
				empBo.setMgrNo(rs.getInt(6));
				listBO.add(empBo);
			}
			return listBO;
		}catch(SQLException se) {
			throw se;
		}catch(Exception e) {
			throw e;
		}
	}
}
