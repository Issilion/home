package home.core.service;

import java.util.List;

import home.core.model.User;

public interface IUserService {
	void add(User user);

	List<User> listUsers();
}
