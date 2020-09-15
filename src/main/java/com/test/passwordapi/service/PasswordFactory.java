package com.test.passwordapi.service;

import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class PasswordFactory {

	public Password getPassword(List<String> trimmedWords) {

		String password = "";
		while (password.length() < 16) {
			password = makePassword(trimmedWords);
		}
		return new Password(password);
	}

	public TreeMap<Integer, String> extractWordsFromSentence(String sentence) {
		sentence = sentence.replaceAll("/(?=[a-zA-Z])", " ");

		String[] words = sentence.split(" |\n");
		TreeMap<Integer, String> trimmedWords = new TreeMap<Integer, String>();
		Integer key = 0;
		for (String word : words) {
			while (word.matches("^[^a-zA-Z0-9�$].*$|^.*[^a-zA-Z0-9%]$") && !word.matches("^[&+-=]$")) {
				word = word.replaceAll("^[^a-zA-Z0-9�$]|[^a-zA-Z0-9%]$", "");

			}

			if (word.length() > 0) {
				String trimmedWord = word;
				trimmedWords.put(key, trimmedWord);
				key++;
			}
		}
		return trimmedWords;
	}

	public String makePassword(List<String> words) {
		int[] word = new int[2];
		for (int i = 0; i < 2; i++) {
			word[i] = (int) (Math.random() * words.size());
		}
		int N = (int) (Math.random() * 100);
		return words.get(word[0]) + words.get(word[1]) + N;
	}

}
