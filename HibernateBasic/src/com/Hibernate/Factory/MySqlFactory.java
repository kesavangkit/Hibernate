package com.Hibernate.Factory;

import com.Hibernate.Dao.IDao;
import com.Hibernate.Dao.MysqlDao;

/**
 * @author KGovintharaj
 *
 */
public class MySqlFactory extends AbstractFactory{

	@Override
	public IDao getDao() {
		return new MysqlDao();
	}

}
