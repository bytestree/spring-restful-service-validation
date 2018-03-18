package com.bytestree.restful.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author BytesTree
 *
 */
@Entity
@Table(name = "email")
public class Email implements Serializable {

	private static final long serialVersionUID = 8453121353060922344L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emailId", unique = true, nullable = false)
	private Long emailId;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	@Column(name = "email", length = 50)
	private String email;

	public Email() {
	}

	public Email(Employee employee, String email) {
		this.employee = employee;
		this.email = email;
	}

	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
