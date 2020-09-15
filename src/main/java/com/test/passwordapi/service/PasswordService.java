package com.test.passwordapi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.passwordapi.data.FileLoader;

@Service
public class PasswordService {

	private String file;
	private FileLoader fl = new FileLoader();
	TreeMap<Integer, String> wordList = new TreeMap<Integer, String>();
	@Autowired
	PasswordFactory pf;

	@PostConstruct
	public void loadFile() throws IOException {
		file = fl.fileReader("text");
		wordList = pf.extractWordsFromSentence(file);
	}

	public Password getPassword() throws IOException {
		Collection<String> values = wordList.values();
		List<String> words = new ArrayList<String>(values);
		return pf.getPassword(words);
	}

}
