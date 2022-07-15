package com.nt.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("controller")
public class MainController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public List<EmployeeVO> displayEmpsByDesgs(String desgs[]) throws SQLException, Exception{
		List<EmployeeVO> listVO = new ArrayList<EmployeeVO>();
		try {
			List<EmployeeDTO> listDTO = service.fetchEmpsByDesgs(desgs);
			listDTO.forEach(dto->{
				EmployeeVO vo = new EmployeeVO();
				BeanUtils.copyProperties(dto, vo);
				listVO.add(vo);
			});
			return listVO;
		}catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
