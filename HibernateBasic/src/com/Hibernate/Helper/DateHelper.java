package com.Hibernate.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author KGovintharaj
 *
 */
public class DateHelper {

	private static final String US_DATE_FORMAT = "MM/dd/yyyy"; // h:mm a

	private static final String UK_DATE_FORMAT = "dd/MM/yyyy"; // HH:mm

	private static final String ARABIC_DATE_FORMAT = "dd/MM/yyyy"; // hh:mm a

	private static final String CHINA_DATE_FORMAT = "yyyy-MM-dd"; // ah:mm

	private static final String TAIWAN_DATE_FORMAT = "yyyy/MM/dd"; // a h:mm

	private static final String Mexico_Date_Format = "dd/MM/yyyy"; // AISG DATE Format

	private static final String JAPAN_DATE_FORMAT = "yyyy/MM/dd";

	private static final String INDIA_DATE_FORMAT = "yyyy-MM-dd";

	private static final String TODAY = "today";

	private static final String TOMORROW = "tomorrow";

	private static final String YESTERDAY = "yesterday";

	private static final String TIME = "TIME";

	public static final String getLocaleDateFormat()
	{  
		String pattern = null;

		Locale myLocale = Locale.getDefault();
		String country = myLocale.getCountry();

		if (country.equalsIgnoreCase("IN")) {
			pattern = INDIA_DATE_FORMAT;
		}
		else  if (myLocale.getCountry().equalsIgnoreCase(Locale.US.getCountry()))
			pattern = US_DATE_FORMAT;
		else if ( country.equalsIgnoreCase(Locale.UK.getCountry())	
				|| country.equalsIgnoreCase("GB")
				|| country.equalsIgnoreCase("AU"))
			pattern = UK_DATE_FORMAT;
		else if ( country.equalsIgnoreCase("AE") ||
				myLocale.getLanguage().equalsIgnoreCase("AR"))
			pattern = ARABIC_DATE_FORMAT;
		else if (country.equalsIgnoreCase(Locale.TAIWAN.getCountry()))
			pattern = TAIWAN_DATE_FORMAT;
		else if ( country.equalsIgnoreCase(Locale.CHINA.getCountry())
				|| country.equalsIgnoreCase("HK")
				|| myLocale.getLanguage().equalsIgnoreCase(Locale.CHINESE.getLanguage()))
			pattern = CHINA_DATE_FORMAT;
		else if (country.equalsIgnoreCase("MX"))
			pattern = Mexico_Date_Format;
		else if (myLocale.getCountry().equalsIgnoreCase(Locale.JAPANESE.getCountry()) || myLocale.getCountry().equalsIgnoreCase(Locale.JAPAN.getCountry()))
			pattern = JAPAN_DATE_FORMAT;
		else
			// default to US if doesnt fit above
			pattern = US_DATE_FORMAT;

		return pattern;
	}

	public static final Date stringToDate(String strDate) throws IllegalArgumentException
	{
		String pattern = getLocaleDateFormat();
		Date ret = stringToDate(strDate, pattern);
		return ret;
	}

	public static Date stringToDate(String strDate, String pattern) throws IllegalArgumentException
	{
		Date ret = null;
		if (strDate == null || strDate.isEmpty()) return ret;

		if(pattern == null || pattern.isEmpty())
			pattern = getLocaleDateFormat();

		if (strDate.matches("([0-9]{1,2})/([0-9]{1,2})/([0-9]{4})") && JAPAN_DATE_FORMAT.equalsIgnoreCase(pattern)){
			pattern = US_DATE_FORMAT;
		}

		SimpleDateFormat myDateFormatter = new SimpleDateFormat(pattern);

		if(strDate.equals(TIME) || strDate.equalsIgnoreCase(TODAY))
			strDate =  myDateFormatter.format(new Date());
		else if(strDate.equalsIgnoreCase(TOMORROW))
		{
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 1); 
			strDate =  myDateFormatter.format(calendar.getTime());
		}
		else if(strDate.equalsIgnoreCase(YESTERDAY))
		{
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1); 
			strDate =  myDateFormatter.format(calendar.getTime());
		}

		try 
		{
			ret = myDateFormatter.parse(strDate);
		} catch (ParseException e) 
		{
			System.err.println(e.getMessage()); 
			e.printStackTrace();
			throw new IllegalArgumentException("Date \"" + strDate
					+ "\" does not match the date format \"" + pattern + "\"");
		}

		return ret;
	}
}