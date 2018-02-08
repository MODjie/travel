package com.java.travel.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	/**
	 * ��ȡ����һ
	 * 
	 * @param date
	 * @return
	 */
	public static Date geLastWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, -7);
		return cal.getTime();
	}

	/**
	 * ��ȡ����һ
	 * 
	 * @param date
	 * @return
	 */
	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// ��õ�ǰ������һ�����ڵĵڼ���
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// ����һ�����ڵĵ�һ�죬���й���ϰ��һ�����ڵĵ�һ��������һ
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// ��õ�ǰ������һ�����ڵĵڼ���
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// ���������Ĺ��򣬸���ǰ���ڼ�ȥ���ڼ���һ�����ڵ�һ��Ĳ�ֵ
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}

	/**
	 * ��ȡ����һ
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekMonday(date));
		cal.add(Calendar.DATE, 7);
		return cal.getTime();
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("2018-02-08");
			System.out.println("������" + sdf.format(date));
			System.out.println("����һ" + sdf.format(geLastWeekMonday(date)));
			System.out.println("����һ" + sdf.format(getThisWeekMonday(date)));
			System.out.println("����һ" + sdf.format(getNextWeekMonday(date)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}