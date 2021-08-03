package com.Hibernate.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.Hibernate.Constant.GenericHelper;
import com.Hibernate.Dto.RegisterDto;
import com.Hibernate.Entity.AbstractEntity;
import com.Hibernate.Entity.StaffEntity;
import com.Hibernate.Entity.StudentEntity;
import com.Hibernate.Enum.ActionTypeEnum;
import com.Hibernate.Enum.OperatorEnum;

/**
 * @author KGovintharaj
 *
 */
public class OracleDao implements IDao{

	private Session session;

	public boolean register(RegisterDto studentDto) {
		insertORupdateStudent(studentDto);
		return true;
	}


	/**
	 * @param studentDto
	 */
	public void insertORupdateStudent(RegisterDto registerDto){
		persiststoDB(createEntity(registerDto));
	}

	/**
	 * @param registerDto
	 * @return
	 */
	private AbstractEntity createEntity(RegisterDto registerDto) {
		if(registerDto.GetActionTypeEnum() == ActionTypeEnum.STUDENT){
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setStudentName(registerDto.getStudentName());
			studentEntity.setRollNo(registerDto.getRollNo());
			studentEntity.setCourse(registerDto.getCourse());
			studentEntity.setDob(registerDto.getDob());
			return studentEntity;
		}else if(registerDto.GetActionTypeEnum() == ActionTypeEnum.STAFF){
			StaffEntity staffEntity = new StaffEntity();
			staffEntity.setStaffName(registerDto.getStudentName());
			staffEntity.setRegisterNo(registerDto.getRollNo());
			staffEntity.setSubject(registerDto.getCourse());
			staffEntity.setDoj(registerDto.getDob());
			return staffEntity;
		}
		return null;
	}


	/**
	 * @param abstractEntity
	 */
	private void persiststoDB(AbstractEntity abstractEntity) {
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(abstractEntity);	
		session.getTransaction().commit();
	}


	/* (non-Javadoc)
	 * @see com.Hibernate.Dao.IDao#search(com.Hibernate.Dto.RegisterDto)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean search(RegisterDto dto) {

		Criteria cr = null;
		Criterion criterion = null;

		if(dto.GetActionTypeEnum() == ActionTypeEnum.STUDENT){
			cr = getSession().createCriteria(StudentEntity.class);
			criterion = getRestrictions("rollNo", dto.getRollNo(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("studentName", dto.getStudentName(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("course", dto.getCourse(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("dob", dto.getDob(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			/*
			 StringBuilder whereClause = new StringBuilder(" where ");
			String hql = "FROM "+dto.GetActionTypeEnum().getEntityName();
			Query query= null;
			if(!GenericHelper.isBlank(dto.getStudentName())){
				whereClause.append("studentName").append(dto.getOperatorEnum().getStringValue()).append(":studentName");
			}
			if(!GenericHelper.isBlank(dto.getRollNo())){
				whereClause.append("rollNo").append(dto.getOperatorEnum().getStringValue()).append(":rollNo");
			}
			if(whereClause.toString().length() > 7){
				hql = hql + whereClause.toString();
			}

			query = getSession().createQuery(hql);

			if(!GenericHelper.isBlank(dto.getStudentName())){
				query.setParameter("studentName", dto.getStudentName());
			}
			if(!GenericHelper.isBlank(dto.getRollNo())){
				query.setParameter("rollNo", dto.getRollNo());
			}*/
		}else if(dto.GetActionTypeEnum() == ActionTypeEnum.STAFF){
			cr = getSession().createCriteria(StaffEntity.class);
			criterion = getRestrictions("registerNo", dto.getRollNo(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("staffName", dto.getStudentName(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("subject", dto.getCourse(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			criterion = getRestrictions("doj", dto.getDob(), dto.getOperatorEnum());
			if(criterion != null){
				cr.add(criterion);
			}
			/*if(GenericHelper.isBlank(dto.getStudentName())){
				whereClause.append("staffName").append(dto.getOperatorEnum().getStringValue()).append(":staffName");
			}
			if(whereClause.toString().length() > 7){
				hql = hql + whereClause.toString();
			}
			query = getSession().createQuery(hql);
			if(GenericHelper.isBlank(dto.getStudentName())){
				query.setParameter("staffName", dto.getStudentName());
			}*/
		}
		List<String> resultList = new ArrayList<String>();
		StringBuilder value = null;
		if(dto.GetActionTypeEnum() == ActionTypeEnum.STUDENT){
			List<StudentEntity> studentEntities = cr.list();
			if(studentEntities == null || studentEntities.isEmpty()){
				dto.setNoRecordsMsg("No Records to show.");
				System.out.println("No Records to show.");
			}
			for (StudentEntity studentEntity : studentEntities) {
				value = new StringBuilder(studentEntity.getStudentName());
				value.append(",").append(studentEntity.getRollNo());
				value.append(",").append(studentEntity.getCourse());
				resultList.add(value.toString());

				System.out.println("User Name: "+studentEntity.getStudentName());
				System.out.println("User Id: "+studentEntity.getId());
				System.out.println("Roll Num: "+studentEntity.getRollNo());
				System.out.println("Course: "+studentEntity.getCourse());
			}
		}else{
			List<StaffEntity> staffEntities = cr.list();
			if(staffEntities == null || staffEntities.isEmpty()){
				dto.setNoRecordsMsg("No Records to show.");
				System.out.println("No Records to show.");
			}
			for (StaffEntity staffEntity : staffEntities) {
				value = new StringBuilder(staffEntity.getStaffName());
				value.append(",").append(staffEntity.getRegisterNo());
				value.append(",").append(staffEntity.getSubject());
				resultList.add(value.toString());

				System.out.println("Staff Name: "+staffEntity.getStaffName());
				System.out.println("Staff Id: "+staffEntity.getId());
				System.out.println("Register Num: "+staffEntity.getRegisterNo());
				System.out.println("Subject: "+staffEntity.getSubject());
			}
		}
		dto.setResultList(resultList);
		return true;
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @param operatorEnum
	 * @return
	 */
	private Criterion getRestrictions(String fieldName, Object fieldValue, OperatorEnum operatorEnum) {

		if(fieldValue == null || GenericHelper.isBlank(fieldValue.toString())){
			return null;
		}

		SimpleExpression criteria = null;
		switch (operatorEnum) {
		case EQ:
			criteria = Restrictions.eq(fieldName, fieldValue);
			break;
		case GE:
			criteria = Restrictions.ge(fieldName, fieldValue);
			break;
		case GT:
			criteria = Restrictions.gt(fieldName, fieldValue);
			break;
		case LE:
			criteria = Restrictions.le(fieldName, fieldValue);
			break;
		case LT:
			criteria = Restrictions.lt(fieldName, fieldValue);
			break;
		case NE:
			criteria = Restrictions.ne(fieldName, fieldValue);
			break;
		case BG:
			criteria = Restrictions.like(fieldName, fieldValue.toString(), MatchMode.START);
			break;
		case MA:
			criteria = Restrictions.like(fieldName, fieldValue.toString(), MatchMode.ANYWHERE);
			break;
		default:
			break;
		}
		return criteria;
	}


	/**
	 * @return the session
	 */
	public Session getSession() {
		if(session == null){
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
			session = sessionFactory.openSession();
			setSession(session);

		}
		return session;
	}
	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
}