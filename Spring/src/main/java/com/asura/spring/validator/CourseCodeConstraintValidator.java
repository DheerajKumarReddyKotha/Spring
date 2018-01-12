package com.asura.spring.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.asura.spring.annotation.CourseCode;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
		
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		Boolean result;
		if(code != null) {
			result = code.startsWith(coursePrefix);
		}else {
			result = true;
		}
		return result;
	}

}
