package com.nt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeDAO empDAO;
	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws SQLException, Exception {
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		try {
			List<EmployeeBO> empBO = empDAO.getEmpsByDesgs(desgs);
			empBO.forEach( bo->{
				EmployeeDTO dto = new EmployeeDTO();
				BeanUtils.copyProperties(bo, dto);
				listDTO.add(dto);
			} );
			return listDTO;
			
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
