package com.test.passwordapi;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.passwordapi.data.FileLoader;
import com.test.passwordapi.service.Password;
import com.test.passwordapi.service.PasswordService;

@SpringBootTest
class PasswordApiApplicationTests {

	@Autowired
	PasswordService ps;

	@Test
	void passwordIsOver16CharsAndContainsNumber() throws IOException {
		Password password = ps.getPassword();
		assertTrue(password.getPassword().matches("^*.*.[0-9]$") && password.getPassword().length() > 16);

	}

	@Test
	void fileReaderThrowsIOExceptionWhenFileNameIsInvalid() {
		FileLoader fl = new FileLoader();
		assertThrows(IOException.class, () -> fl.fileReader("qwerty"));
	}

}
