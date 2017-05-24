package edu.mum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.User;
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;

@RestController
@RequestMapping("/api/auth")
public class LoginRestController {
	@Autowired
	UserCredentialsService credentialsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> postLogin(UserCredentials req) {

		System.out.println(req);
		User u = new User();
		u.setFirstName(req.getUserName());
		u.setLastName(req.getPassword());
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void logoutLogin(HttpSession session) {
		session.invalidate();
	}
}