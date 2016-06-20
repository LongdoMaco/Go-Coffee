package common; 

import java.sql.Date;

/**
 * StringProcess.java
 *
 * Version 1.0
 *
 * Date: Jan 20, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 20, 2015        	DaiLV2          Create
 */

public class StringProcess {
	
	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if("0".equals(val)){
			return "Nu";
		}
		return "Nam";
	}
	
	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if(s==null) return "";
		return s;
	}
	
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	
	public static boolean isSpace(String s){
		if(s==null || s.length()==0) return false;
		int b = s.length();
		String a = s.replaceAll(" ", "");
		int c = a.length();
		if(b == c){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s){
		if(notVaild(s)) return false;
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return false;
		return true;
	}
	public static boolean notVaildNumber2(String s){
		if(notVaild(s)) return true;
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return false;
		return true;
	}
	
	public static boolean notValidNumber(int s)
	{
		String a=Integer.toString(s);
		if(notVaild(a)) return true;
		String regax="[0-9]+";
		if(a.matches(regax)) return false;
		return true;
	}

	public static boolean isEmptyString(String ngaySinh) {
		String str=ngaySinh.toString();
		if("mm/dd/yyyy".equals(str)) return true;
		return false;
	}
}

