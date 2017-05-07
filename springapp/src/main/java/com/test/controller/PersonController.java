package com.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.Person;

@Controller
public class PersonController {
	private static Logger logger = LoggerFactory.getLogger(PersonController.class); 

	@Autowired
	private PersonValidator personValidator;
	
	@RequestMapping(method=RequestMethod.GET,value="/addPerson")
	public ModelAndView addPerson(){
		logger.debug(">>>>>>>>>>>>>>>>>>>>> HERE");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addPerson");
		Person person = new Person();
		person.setCity("Plymouth");
		modelAndView.addObject("person", person);
		//modelAndView.addObject("myDeviceData","WQFSADFH345345ADASD345345");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/savePerson")
	public ModelAndView savePerson(Person person,Errors errors){ //@RequestParam("deviceID") String id
		logger.debug(">>>>>>>>>>>>>>>>>>>>> HERE" + person);
		ModelAndView modelAndView = new ModelAndView();
		personValidator.validate(person, errors);
		if(errors.hasErrors()){
			modelAndView.setViewName("addPerson");
			modelAndView.addObject("person", person);
		}else{
			modelAndView.setViewName("success");
			modelAndView.addObject("message", person.getPid() + " Person Added in DB.");
		}
		return modelAndView;
	}
}
