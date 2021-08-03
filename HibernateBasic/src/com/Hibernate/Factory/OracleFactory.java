package com.Hibernate.Factory;

import com.Hibernate.Dao.IDao;
import com.Hibernate.Dao.OracleDao;

/**
 * @author KGovintharaj
 *
 */
public class OracleFactory extends AbstractFactory{

	@Override
	public IDao getDao() {
		 return new OracleDao();
	}

}
