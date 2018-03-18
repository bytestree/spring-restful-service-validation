package com.bytestree.restful.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author BytesTree
 *
 */
@Entity
@Table(name = "employee")
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId", unique = true, nullable = false)
	private Long employeeId;

	@Column(name = "firstName", length = 50)
	private String firstName;

	@Column(name = "lastName", length = 50)
	private String lastName;

	@Column(name = "designation", length = 20)
	private String designation;

	@Column(name = "salary")
	private Integer salary;

	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<Email> emails = new HashSet<>(0);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (employeeId == null || obj == null || getClass() != obj.getClass())
			return false;
		Employee toCompare = (Employee) obj;
		return employeeId.equals(toCompare.employeeId);
	}

	@Override
	public int hashCode() {
		return employeeId == null ? 0 : employeeId.hashCode();
	}

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

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}
}
