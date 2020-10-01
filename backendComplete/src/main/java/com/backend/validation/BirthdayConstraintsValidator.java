package com.backend.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class BirthdayConstraintsValidator implements ConstraintValidator<BirthdayConstraints,String> {
	
	
	
	@Override
	public void initialize(BirthdayConstraints data) {
	}
	
	@Override
	public boolean isValid(String date, ConstraintValidatorContext 
			theConstraintValidatorContext) {
		if(date==null || date.isEmpty()) {
			return false;
		}
		String pat="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$";
		if(!date.matches(pat)) {
			return false;
		}
		
		return checkDate(date);
		
	}
	
	private boolean checkDate(String bday) {
		
		
		int base_counter=0;
		int top_counter=bday.indexOf("/");
		
		String s_dd=bday.substring(base_counter,top_counter);
		base_counter=top_counter+1;
		top_counter=bday.indexOf("/",top_counter+1);
		
		String s_mm=bday.substring(base_counter,top_counter);
		base_counter=top_counter+1;
		top_counter=bday.length();
		String s_yy=bday.substring(base_counter,top_counter);
		int dd = Integer.parseInt(s_dd);
		int mm = Integer.parseInt(s_mm);
		int yy = Integer.parseInt(s_yy);
		
		int age=2020-yy;
		if((dd>0 && dd<=31) && (mm>0 && mm<=12) && (age>=18 && age <130)) {
			return true;
		}
		else {
			System.out.print("ur age is too small "+dd+mm+age);
		}
			return false;
	}

}
