package com.Hibernate.Dao;

import com.Hibernate.Dto.RegisterDto;

/**
 * @author KGovintharaj
 *
 */
public interface IDao {

	/**
	 * @param registerDto
	 * 
	 * @return
	 */
	public boolean register(RegisterDto registerDto);

	/**
	 * @param dto
	 * 
	 * @return
	 */
	public boolean search(RegisterDto registerDto);
}