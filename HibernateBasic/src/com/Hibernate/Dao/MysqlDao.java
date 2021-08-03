package com.Hibernate.Dao;

import com.Hibernate.Dto.RegisterDto;

/**
 * @author KGovintharaj
 *
 */
public class MysqlDao implements IDao{

	public boolean register(RegisterDto registerDto) {
		System.out.println("In Mysql Dao..");
		return true;
	}

	public boolean search(RegisterDto dto) {
		return false;
	}
}