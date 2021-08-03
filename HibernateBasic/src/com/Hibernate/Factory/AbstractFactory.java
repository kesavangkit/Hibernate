package com.Hibernate.Factory;

import com.Hibernate.Dao.IDao;

/**
 * @author KGovintharaj
 *
 */
public abstract class AbstractFactory {
	public abstract IDao getDao();
	
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("Oracle")){
			return new OracleFactory();
		}else{
			return new MySqlFactory();
		}
	}
}
