package com.Hibernate.Constant;

import java.util.Date;

import com.Hibernate.Dto.RegisterDto;
import com.Hibernate.Enum.ActionTypeEnum;

/**
 * @author KGovintharaj
 *
 */
public class ValidationService {

	/**
	 * @param registerDto
	 * 
	 * @return
	 */
	public boolean validateInsert(RegisterDto registerDto) {
		boolean isValid = true;

		if(registerDto.getStudentName() == null || registerDto.getStudentName().isEmpty()){
			registerDto.getErrorMesageList().add("Name must be entered.");
			isValid = false;
		}

		if(registerDto.getRollNo() == null || registerDto.getRollNo().isEmpty()){
			registerDto.getErrorMesageList().add("RollNo must be entered.");
			isValid = false;
		}

		if(registerDto.getCourse() == null || registerDto.getCourse().isEmpty()){
			registerDto.getErrorMesageList().add("Course must be entered.");
			isValid = false;
		}
		if(registerDto.getDob() == null){
			registerDto.getErrorMesageList().add("Date of birth must be entered.");
			isValid = false;
		}else if(registerDto.getDob().after(new Date())){
			registerDto.getErrorMesageList().add("Date cannot be in future.");
			isValid = false;
		}

		if(registerDto.getType() == null || registerDto.getType().isEmpty()){
			registerDto.getErrorMesageList().add("Type must be Selected.");
			isValid = false;
		}

		return isValid;
	}

	/**
	 * @param registerDto
	 * 
	 * @return
	 */
	public boolean validateSearch(RegisterDto registerDto) {
		boolean isValid = true;

		if(registerDto.GetActionTypeEnum() == ActionTypeEnum.BLANK){
			registerDto.getErrorMesageList().add("Type must be Selected.");
			isValid = false;
		}

		if(registerDto.getOperator() == null || registerDto.getOperator().isEmpty()){
			registerDto.getErrorMesageList().add("Operator must be Selected.");
			isValid = false;
		}

		return isValid;
	}
}