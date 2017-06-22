package home.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

@Configuration
@EnableSocial
public class SocialConfig implements SocialConfigurer {

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
	    connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
	        environment.getProperty("spring.social.facebook.appId"),
	        environment.getProperty("spring.social.facebook.appSecret")));
	    connectionFactoryConfigurer.addConnectionFactory(new TwitterConnectionFactory(
	        environment.getProperty("twitter.consumerKey"),
	        environment.getProperty("twitter.consumerSecret")));
	    connectionFactoryConfigurer.addConnectionFactory(new LinkedInConnectionFactory(
	        environment.getProperty("spring.social.linkedin.appId"),
	        environment.getProperty("spring.social.linkedin.appSecret")));
	    connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory(
	        environment.getProperty("spring.social.google.appId"),
	        environment.getProperty("spring.social.google.appSecret")));
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
