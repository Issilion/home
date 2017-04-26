package home.core.dao;

import java.util.List;

import home.core.model.User;

public interface IUserDao {
	void add(User user);

	List<User> listUsers();

	User findByUserName(String username);
}
