package com.usersApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<User> read() {

		return jdbcTemplate.query("SELECT id, name, email, pwd FROM users", new UserRowMapper());
	}

	public boolean insert(User user) {

		int success = 0;
		success = jdbcTemplate.update("INSERT INTO users (name, email, pwd) VALUES (?,?,?)",
				new Object[] { user.getName(), user.getEmail(), user.getPwd() });

		if (success > 0) {
			return true;
		}

		return false;
	}

	public boolean delete(long idUser) {

		int success = 0;
		success = jdbcTemplate.update("DELETE FROM users WHERE id = ?", new Object[] { idUser });

		if (success > 0) {
			return true;
		}

		return false;
	}

	public boolean update(User user) {

		int success = 0;
		success = jdbcTemplate.update("UPDATE users SET name =  ?, email = ?, pwd = ? WHERE id = ?",
				new Object[] { user.getName(), user.getEmail(), user.getPwd(), user.getId() });

		if (success > 0) {
			return true;
		}

		return false;

	}

}
