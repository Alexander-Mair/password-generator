package com.test.passwordapi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.passwordapi.service.Password;
import com.test.passwordapi.service.PasswordService;

@RestController
@RequestMapping("/password")
public class Controller {
	@Autowired
	PasswordService ps;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Password sendPassword() throws IOException {

		Password password = ps.getPassword();
		return password;
	}

}
