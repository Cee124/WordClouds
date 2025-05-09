package de.hs_mannheim.informatik.wordcloud.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class WordFrequency {

	private static HashMap<String, Integer> wordFrequencies;

	public WordFrequency() {
		wordFrequencies = new HashMap<>();
	}

	public HashMap<String, Integer> getWordFrequencies() {
		return wordFrequencies;
	}

	public void addFrequencies(ArrayList<String> words) {
		for (String w : words) {

			wordFrequencies.put(w, wordFrequencies.getOrDefault(w, 0) + 1);
		}

	}

}
