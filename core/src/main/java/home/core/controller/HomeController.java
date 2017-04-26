package home.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import home.core.config.PostgreConfig;
import home.core.service.IUserService;

@Controller
public class HomeController {
	AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(PostgreConfig.class);

	IUserService userService = context.getBean(IUserService.class);
	 
	@RequestMapping(value="/home")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/protected**", method = RequestMethod.GET)
	public ModelAndView protectedPage() {
		
		
		ModelAndView model = new ModelAndView();
	//	userService.add(new User("user" , "123", "user"));
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is protected page - Only for Admin Users!");
		model.setViewName("protected");
		return model;

	}

	@RequestMapping(value = "/confidential**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is confidential page - Need Super Admin Role!");
		model.setViewName("protected");

		return model;

	}

}
