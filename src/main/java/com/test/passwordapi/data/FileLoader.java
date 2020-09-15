package com.test.passwordapi.data;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileCopyUtils;

public class FileLoader {

	public String fileReader(String filename) throws IOException {
		final Logger LOGGER = LoggerFactory.getLogger(getClass());

		Resource resource = new ClassPathResource(filename);
		InputStream inputStream = resource.getInputStream();
		byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
		String file = new String(bdata, StandardCharsets.UTF_8);
		LOGGER.info(file);
		return file;

	}

}
