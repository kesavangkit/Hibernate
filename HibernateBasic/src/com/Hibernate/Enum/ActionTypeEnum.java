package com.Hibernate.Enum;

public enum ActionTypeEnum {

	BLANK("", "", ""),
	STUDENT("Student", "Student", "StudentEntity"),
	STAFF("Staff", "Staff", "StaffEntity");

	String stringValue;
	String lable;
	String entityName;


	private ActionTypeEnum(String stringValue, String lable, String entityName) {
		this.stringValue = stringValue;
		this.lable = lable;
		this.entityName = entityName;
	}

	public static ActionTypeEnum getDescriptiveValue(String value)
	{
		if (value != null && value.isEmpty())
			return BLANK;

		for (ActionTypeEnum status : ActionTypeEnum.values())
		{
			if (status.getStringValue().equalsIgnoreCase(value))
			{
				return status;
			}
		}

		return BLANK;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @return the lable
	 */
	public String getLable() {
		return lable;
	}

	/**
	 * @return the entityName
	 */
	public String getEntityName() {
		return entityName;
	}
}
