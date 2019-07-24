package com.revature.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository("ur")
public interface UserRepository {
	User getUserByUsername(String username);
	void newUser(User u);
}
