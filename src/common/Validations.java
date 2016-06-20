package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validations {

	public static boolean validateEmailAddress(String emailAddress) {
		String regex = "[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}";
		return emailAddress.matches(regex);
	}
	
	
	public static boolean validatePhoneNumber(String phoneNumber) {
		String regex = "(0\\d{9,11})";
		return phoneNumber.matches(regex);

	}
	public static boolean validateDate(String strDate1, String strDate2){
		if (strDate1 == null || strDate2 == null) {
			return true;
		}
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		formatDate.setLenient(false);
		try {
			Date date1 = formatDate.parse(strDate1);
			Date date2 = formatDate.parse(strDate2);
			if (date1.after(date2)){
				return true;
			} 
			else {
				return false;
			}
		} catch (ParseException e) {
			return true;
		}
	}
	public static boolean validateDate(String strDate) {
		if (strDate == null ||"".equals(strDate)) {
			return true;
		}
//		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
//		formatDate.setLenient(false);
//		try {
//			formatDate.parse(strDate);
//		} catch (ParseException e) {
//			return true;
//		}
		else return false;
	}
	public static boolean validateDate(Date date) {
		if (date == null) {
			return false;
		}
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		try {
			formatDate.format(date);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public static boolean validateTenThanhVien(String str) {
		if ( str.length()> 30)
			return true;
		return false;
	}
	public static boolean validateDiaChi(String str) {
		if ( str.length()> 50)
			return false;
		return true;
	}
	public static boolean validateHoTen(String str) {
		if ( str.length()> 30)
			return false;
		return true;
	}
	public static boolean validatePass(String str) {
		if ( str.length()> 20)
			return false;
		return true;
	}
	public static boolean validateMaxLength(String str,int n) {
		if ( str.length()> n)
		{
			return false;
		}
			
		else return true;
	}
	public static boolean validateMinLength(String str,int n) {
		if ( validateNull(str)==false && str.length()< n)
			return true;
		else
		return false;
	}
	public static boolean validateNull(String str) {
		if (str == null || str.length() == 0)
			return true;
		return false;
	}
	public static boolean validateTrungMatKhau(String matKhauCu, String matKhauMoi) {
		if ( matKhauCu.equals(matKhauMoi))
			return true;
		return false;
	}
	
	public static boolean checkConfirmMK(String matKhauMoi, String matKhauConfirm){
		if(validateNull(matKhauConfirm)) return false;
			
		String a=matKhauMoi;
		String b=matKhauConfirm;
		if(a.equals(b))
		{
			return true;
		}
		else return false;
	}
	

	
	public static boolean checkEmail( String email ){
		if(validateNull(email)) return true;
        StringBuilder regex = new StringBuilder();
        regex.append("^");
        regex.append("[_a-z0-9-]+(\\.[_a-z0-9-]+)*@([a-z0-9]+\\.com)");
        regex.append("$");
        Pattern pattern = Pattern.compile(regex.toString());
        Matcher matcher = pattern.matcher(email);
        boolean valid = matcher.matches();
        if (valid) {
            return true;
        } else {
            return false;
        }
	}
	
	
	
	
	
	public static boolean isNumber(String str){
		if(validateNull(str)) return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static void main(String[] args) {

//		String emailAddress = "nguyetitbkdn@gmail.com";
//		String mobileNumber = "016397307734";
//		String brithday = "25/12/1993";
//		System.out.println(Validations.validateEmailAddress(emailAddress));
//		System.out.println(Validations.validatePhoneNumber(mobileNumber));
//		System.out.println(Validations.validateDate(brithday));
//		System.out.println(Validations.validateDate("29/12/2015", "28/12/2015"));
		Date date = new Date();
//		System.out.println(date);
		System.out.println(checkEmail("asdsad"));
		
		
		
	}
}
