package com.bytestree.restful.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDO implements Serializable {

	private static final long serialVersionUID = -5662688722276730214L;

	private Long employeeId;

	@NotEmpty(message = "{employee.firstName.required}")
	private String firstName;

	@NotEmpty(message = "{employee.lastName.required}")
	private String lastName;

	@NotEmpty(message = "{employee.designation.required}")
	private String designation;

	@NotNull(message = "{employee.salary.required}")
	@Positive(message = "{employee.salary.invalid}")	
	private Integer salary;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Past(message = "{employee.dateOfBirth.invalid}")
	private Date dateOfBirth;
	
	List<@NotEmpty(message = "{employee.email.invalid}") @Email(message = "{employee.email.invalid}") String> emails;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDO [employeeId=");
		builder.append(employeeId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", emails=");
		builder.append(emails);
		builder.append("]");
		return builder.toString();
	}

	

}
