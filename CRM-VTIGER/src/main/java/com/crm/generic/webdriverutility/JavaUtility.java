package com.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public String getSystemData() 
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actualdate=sim.format(date);
		return actualdate;
	}
	
	public int getrandomnumber() {
		Random r=new Random();
		return r.nextInt(5000);
	}
	public String getReqDate(int days) {
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");	
		Calendar calendar=sim.getCalendar();
		calendar.add(calendar.DAY_OF_MONTH,days);
		Date date=calendar.getTime();
		String reqdate=sim.format(date);
		
		return reqdate;
		
	}
	

}
