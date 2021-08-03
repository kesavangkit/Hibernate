package com.Hibernate.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author KGovintharaj
 *
 */
@Entity
@Table(name="staff")
public class StaffEntity extends AbstractEntity {

	public StaffEntity() {
		super();
	}

	@Column(name = "staff_name")
	public String staffName;

	@Column(name = "register_no")
	public String registerNo;

	@Column(name="subject")
	public String subject;

	@Column(name="doj")
	@Temporal(TemporalType.DATE)
	public Date doj;

	/**
	 * @return the staffName
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName the staffName to set
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @return the registerNo
	 */
	public String getRegisterNo() {
		return registerNo;
	}

	/**
	 * @param registerNo the registerNo to set
	 */
	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
	}
}