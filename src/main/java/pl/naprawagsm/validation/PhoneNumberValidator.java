package pl.naprawagsm.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean equals9=value.length()==9;
		if(!equals9) {
			return false;
		}
		char[] valueDevidedToSingleLetters = value.toCharArray();
		for(char letter:valueDevidedToSingleLetters) {
			if(!Character.isDigit(letter)) {
				return false;
			}
		}
		
		return true;
	}
}
