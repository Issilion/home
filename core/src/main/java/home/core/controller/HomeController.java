package home.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import home.core.config.PostgreConfig;
import home.core.model.User;
import home.core.service.IUserService;

@Controller
public class HomeController {
	AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(PostgreConfig.class);

	IUserService userService = context.getBean(IUserService.class);
	 
	@RequestMapping(value="/home")
	@Secured(value="ROLE_ADMIN")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		//userService.add(new User("u" , "u", "u"));
		//userService.add(new User("a" , "u", "a"));
		
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/protected**")
	@Secured(value="ROLE_ADMIN")
	public @ResponseBody ModelAndView protectedPage() {
		
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is protected page - Only for Admin Users!");
		model.setViewName("protected");
		return model;

	}

	@RequestMapping(value = "/confidential**")
	public @ResponseBody ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
		model.addObject("message", "This is confidential page - Need Super Admin Role!");
		model.setViewName("protected");

		return model;

	}

}
