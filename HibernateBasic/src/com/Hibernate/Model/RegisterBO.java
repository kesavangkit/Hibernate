package com.Hibernate.Model;

import com.Hibernate.Constant.DBConnectionConstant;
import com.Hibernate.Constant.StringConstant;
import com.Hibernate.Constant.ValidationService;
import com.Hibernate.Dao.IDao;
import com.Hibernate.Dto.RegisterDto;
import com.Hibernate.Factory.AbstractFactory;

/**
 * @author KGovintharaj
 *
 */
public class RegisterBO {

	ValidationService service = new ValidationService();

	/**
	 * @param dto
	 * @return
	 */
	public boolean perform(RegisterDto dto){
		//Finding the factory by passing the choice
		IDao dao = AbstractFactory.getFactory(DBConnectionConstant.ORACLE).getDao();

		boolean isValid = true;
		if(dto.getAction().equalsIgnoreCase(StringConstant.REGISTER)){
			isValid = service.validateInsert(dto);
			return isValid && dao.register(dto);
		}else{
			isValid = service.validateSearch(dto);
			return isValid && dao.search(dto);
		}
	}
}