package com.bytestree.restful.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestree.restful.dto.EmployeeDO;
import com.bytestree.restful.model.Email;
import com.bytestree.restful.model.Employee;
import com.bytestree.restful.repository.EmployeeRepository;

/**
 * 
 * @author BytesTree
 *
 */
@Service
public class DefaultEmployeeService implements EmployeeService {

	final static Logger logger = LoggerFactory.getLogger(DefaultEmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDO save(EmployeeDO employeeDO) {
		Employee employee = employeeRepository.save(tranform(employeeDO));
		return transform(employee);
	}

	@Override
	public List<EmployeeDO> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDO> employeeDOs = employees.stream().map(employee -> transform(employee))
				.collect(Collectors.toList());
		return employeeDOs;
	}

	private Employee tranform(EmployeeDO employeeDO) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDO.getEmployeeId());
		employee.setDateOfBirth(employeeDO.getDateOfBirth());
		employee.setFirstName(employeeDO.getFirstName());
		employee.setDesignation(employeeDO.getDesignation());
		employee.setLastName(employeeDO.getLastName());
		employee.setSalary(employeeDO.getSalary());
		Set<Email> emails = new HashSet<>(0);
		employeeDO.getEmails().stream().forEach(emailAddress -> emails.add(new Email(employee, emailAddress)));
		employee.setEmails(emails);
		return employee;
	}

	private EmployeeDO transform(Employee employee) {
		EmployeeDO employeeDO = new EmployeeDO();
		employeeDO.setEmployeeId(employee.getEmployeeId());
		employeeDO.setDateOfBirth(employee.getDateOfBirth());
		employeeDO.setFirstName(employee.getFirstName());
		employeeDO.setDesignation(employee.getDesignation());
		employeeDO.setLastName(employee.getLastName());
		employeeDO.setSalary(employee.getSalary());
		List<String> emails = employee.getEmails().stream().map(email -> email.getEmail()).collect(Collectors.toList());
		employeeDO.setEmails(emails);
		return employeeDO;
	}
}
