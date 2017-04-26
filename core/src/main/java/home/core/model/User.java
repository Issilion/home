package home.core.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "login")
   private String login;

   @Column(name = "passwrod")
   private String password;
   
   @Column(name = "name")
   private String name;
   
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
   @Column(name = "userRoles")
   private Set<UserRole> userRoles;


   public User(String login, String password, String name, Set<UserRole> userRoles) {
	super();
	this.login = login;
	this.password = password;
	this.name = name;
	this.userRoles = userRoles;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public Set<UserRole> getUserRoles() {
	return userRoles;
}


public void setUserRoles(Set<UserRole> userRoles) {
	this.userRoles = userRoles;
}


public User() {}


public User(String login, String password, String name) {
	super();
	this.login = login;
	this.password = password;
	this.name = name;
}
	   
	
	public Set<UserRole> getUserRole() {
		return this.userRoles;
	}

}