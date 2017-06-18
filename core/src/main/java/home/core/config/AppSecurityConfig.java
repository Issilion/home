package home.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	
	//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PostgreConfig.class);
	//UserDetailsService userDetailsService = context.getBean(UserService.class);
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		/*auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()/*
				.antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')").*/.and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/home", false).and()
					.logout()/*.permitAll()*/.logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);

	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
