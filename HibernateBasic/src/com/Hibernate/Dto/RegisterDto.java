package com.Hibernate.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Hibernate.Enum.ActionTypeEnum;
import com.Hibernate.Enum.OperatorEnum;

/**
 * @author KGovintharaj
 *
 */
public class RegisterDto {

	private int studentId;
	private String studentName;
	private String rollNo;
	private String course;
	private Date dob;
	private String type;
	private String action;
	private String operator;
	private List<String> errorMesageList;
	private List<String> resultList;
	private String noRecordsMsg;

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the errorMesageList
	 */
	public List<String> getErrorMesageList() {
		if(errorMesageList == null){
			errorMesageList = new ArrayList<String>();
		}
		return errorMesageList;
	}

	/**
	 * @param errorMesageList the errorMesageList to set
	 */
	public void setErrorMesageList(List<String> errorMesageList) {
		this.errorMesageList = errorMesageList;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return
	 */
	public OperatorEnum getOperatorEnum(){
		return OperatorEnum.getDescriptiveValue(this.operator);
	}

	/**
	 * @return
	 */
	public ActionTypeEnum GetActionTypeEnum(){
		return ActionTypeEnum.getDescriptiveValue(this.type);
	}
	/**
	 * @return the resultList
	 */
	public List<String> getResultList() {
		if(resultList == null){
			resultList = new ArrayList<String>();
		}
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}
	/**
	 * @return the noRecordsMsg
	 */
	public String getNoRecordsMsg() {
		return noRecordsMsg;
	}
	/**
	 * @param noRecordsMsg the noRecordsMsg to set
	 */
	public void setNoRecordsMsg(String noRecordsMsg) {
		this.noRecordsMsg = noRecordsMsg;
	}
}