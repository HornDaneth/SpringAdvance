package com.mcnc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Note for some usage:
 * 
 * 1. Required libs:
 * -hibernate-validator-4.3.1.final-1.0.0
 * -validation-api-1.1.0.Final
 * 
 * 2.
 * 	@InitBinder initBinder is used when you create a custom Validator by using {@link Validator} Interface
 * 
 * 3. @Validated = @Valid
 * 	Validated offered by Spring, Valid by javax
 * 
 * 4. BindingResult
 * Used to handle own error message, otherwise it will throws error code 400
 * 
 * 5. ValidationUtils.invokeValidator
 * Used to invoked aggregated Validator
 *  
 *
 */

@Controller
@RequestMapping("/validator")
public class ValidatorController {
	
	
	@Autowired @Qualifier("personValidator")
	private Validator validator;
	
	/*@InitBinder
	private void InitBinder(WebDataBinder binder){
		binder.setValidator(validator);
	}*/
	
	
	
	@RequestMapping( value = "/person", method = RequestMethod.GET)
	public @ResponseBody Person validatePerson(@Validated Person person){
		return person;
	}
	
	/**
	 * Handle error on its controller
	 * @param person
	 * @param result Used to manually handle error
	 * @return
	 */
	@RequestMapping( value = "/single", method = RequestMethod.GET)
	public @ResponseBody List<ObjectError> validatePerson(@Valid Person person, BindingResult result){
		if(result.hasErrors()){
			return result.getAllErrors();
		}else{
			return null;
		}
		
	}
}


class Person{
	@NotNull(message="{NotNull.person.id}")
	private String id;
	@NotNull(message="{NotNull.person.name}")
	private String name;
	private String gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}

@Component("personValidator")
class PersonValidator implements Validator{
	
	@Autowired MessageSource messageSource;

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Locale locale = LocaleContextHolder.getLocale();
		String idCode =  "NotNull.person.id";
		String nameCode = "NotNull.person.name";
		
		ValidationUtils.rejectIfEmpty(errors, "id", null, messageSource.getMessage(idCode, null, locale));
		ValidationUtils.rejectIfEmpty(errors, "name", null, messageSource.getMessage(nameCode, null, locale));
		// For Re-Use Validator
		/*Person person = (Person) target;
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator, person.getAddress(), errors);
		} finally {
		    errors.popNestedPath();
		}*/
	}
	
}
