package com.usersApi;

import java.util.List;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	private static Logger LOG = LoggerFactory.getLogger(UserRepository.class);

	@Autowired
	UserRepository userRepo;

	@RequestMapping(value = "listUser", method = RequestMethod.GET)
	public List<User> getUserList() throws ServletException {

		LOG.info("***********************************");
		LOG.info("GET -> getUserList");

		List<User> userLst = userRepo.read();
		return userLst;
	}

	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	public boolean insertUser(@RequestBody User user) {

		LOG.info("***********************************");
		LOG.info("POST -> insertUser");
		boolean success = false;
		success = userRepo.insert(user);

		return success;
	}

	@RequestMapping(value = "deleteUser/{idUser}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathVariable long idUser) {

		LOG.info("***********************************");
		LOG.info("DELETE -> deleteUser");
		boolean success = false;
		success = userRepo.delete(idUser);

		return success;
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.PUT)
	public boolean updateUser(@RequestBody User user) {

		LOG.info("***********************************");
		LOG.info("PUT -> updateUser");
		boolean success = false;
		success = userRepo.update(user);

		return success;
	}

}
