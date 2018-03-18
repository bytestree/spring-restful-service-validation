package com.bytestree.restful.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestree.restful.dto.EmployeeDO;
import com.bytestree.restful.service.EmployeeService;

/**
 * 
 * @author BytesTree
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService empService;

	@PostMapping
	public ResponseEntity<EmployeeDO> addEmployee(@Valid @RequestBody EmployeeDO employeeDO) {
		employeeDO = empService.save(employeeDO);
		logger.debug("Added:: " + employeeDO);
		return new ResponseEntity<EmployeeDO>(employeeDO, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDO>> getAllEmployees() {
		List<EmployeeDO> employeeDOs = empService.getAll();
		if (employeeDOs.isEmpty()) {
			logger.debug("Employees does not exists");
			return new ResponseEntity<List<EmployeeDO>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + employeeDOs.size() + " Employees");
		logger.debug(Arrays.toString(employeeDOs.toArray()));
		return new ResponseEntity<List<EmployeeDO>>(employeeDOs, HttpStatus.OK);
	}
}
