package com.nt.service;

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
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchEmpsByDesgs(String[] desgs) throws Exception {
		List<EmployeeDTO> listDTO = new ArrayList<EmployeeDTO>();
		StringBuilder cond = new StringBuilder();
		
		cond.append("("); 
		for(int i = 0; i < desgs.length; i++) {
			if(i == desgs.length-1) {
				cond.append("'"+desgs[i]+"')");
			}else {
				cond.append("'"+desgs[i]+"', ");
			}
		}
		
		String cond1 = cond.toString();
		List<EmployeeBO> listBO = dao.getEmpsByDesgs(cond1);
		
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}
	
}
