package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeDAO implements IEmployeeDAO {

	@Autowired
	private DataSource ds;

	private static final String EMP_DETAILS_ON_DESGS = "SELECT EMPNO, ENAME, SAL, DEPTNO FROM EMP WHERE JOB IN ";

	@Override
	public List<EmployeeBO> getEmpsByDesgs(String[] desgs) throws SQLException, Exception{
		List<EmployeeBO> listBO = new ArrayList<>(); 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		StringBuilder desgList = new StringBuilder("(");
		for(int i = 0; i< desgs.length; i++) {
			if(i == desgs.length-1)
				desgList.append("'"+desgs[i]+"')");
			else
				desgList.append("'"+desgs[i]+"', ");
		}
		
		try {
			con = ds.getConnection();
			if(con != null)
				stmt = con.createStatement();			
			if(stmt != null)
				rs = stmt.executeQuery(EMP_DETAILS_ON_DESGS+desgList.toString());
			
			while(rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setSalary(rs.getFloat(3));
				bo.setDeptno(rs.getInt(4));
				listBO.add(bo);
			}
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}	
			try {
				if(stmt != null) {
					stmt.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}	
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}	
		}
		return listBO;
	}
}
