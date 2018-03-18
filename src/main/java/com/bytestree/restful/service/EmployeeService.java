package com.bytestree.restful.service;

import java.util.List;

import com.bytestree.restful.dto.EmployeeDO;

/**
 * 
 * @author BytesTree
 *
 */
public interface EmployeeService {
	
	EmployeeDO save(EmployeeDO employeeDO);

	List<EmployeeDO> getAll();
}
