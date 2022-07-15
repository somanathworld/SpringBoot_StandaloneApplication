package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
import com.nt.vo.EmployeeVO;

@Controller("mainController")
public class MainController {

	@Autowired
	private IEmployeeMgmtService service;
	
	public List<EmployeeVO> showEmpsByDesgs(String desgs[]) throws Exception{
		List<EmployeeVO> listVO = new ArrayList<EmployeeVO>();
		List<EmployeeDTO> listDTO = service.fetchEmpsByDesgs(desgs);
		listDTO.forEach(dto->{
			EmployeeVO vo = new EmployeeVO();
			vo.setSrNo(dto.getSrNo().toString());
			vo.setEmpNo(dto.getEmpNo().toString());
			vo.setEname(dto.getEname());
			vo.setJob(dto.getJob());
			vo.setSal(dto.getSal().toString());
			vo.setMgrNo(dto.getMgrNo().toString());
			vo.setDeptNo(dto.getDeptNo().toString());
			listVO.add(vo);
		});
		return listVO;
	}
}
