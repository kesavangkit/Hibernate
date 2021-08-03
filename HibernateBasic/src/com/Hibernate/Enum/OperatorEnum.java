package com.Hibernate.Enum;

/**
 * @author KGovintharaj
 *
 */
public enum OperatorEnum {

	EQ("EQ", "="),
	NE("NE", "<>"),//We can use both '!=' and '<>'
	GE("GE", ">="),
	GT("GT", ">"),
	LE("LE", "<="),
	LT("LT", "<"), 
	BG("BG", ""),
	MA("MA", ""),
	IN("IN", ""),
	BLANK("", "");
	
	String stringName;
	String StringValue;
	
	/**
	 * @param stringName
	 * @param StringValue
	 */
	private OperatorEnum(String stringName, String StringValue) {
		this.stringName = stringName;
		this.StringValue = StringValue;
	}
	
	/**
	 * @return the stringName
	 */
	public String getStringName() {
		return stringName;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return StringValue;
	}
	
	/**
	 * @param value
	 * 
	 * @return
	 */
	public static OperatorEnum getDescriptiveValue(String value)
	{
		if (value == null)
			return BLANK;

		for (OperatorEnum status : OperatorEnum.values())
		{
			if (status.getStringName().equalsIgnoreCase(value))
			{
				return status;
			}
		}

		return BLANK;
	}
}