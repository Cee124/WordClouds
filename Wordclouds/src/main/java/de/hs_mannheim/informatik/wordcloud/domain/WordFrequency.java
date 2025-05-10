package de.hs_mannheim.informatik.wordcloud.domain;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {

	private final  Map<String, Integer> wordFrequencies = new HashMap<>();
	
	public WordFrequency() {
		
	}

	public Map<String, Integer> getWordFrequencies() {
		return wordFrequencies;
	}

	public void addFrequencies(ArrayList<String> words) {
		for (String w : words) {

			wordFrequencies.put(w, wordFrequencies.getOrDefault(w, 0) + 1);
			
		}

	}
	
	public Map<String, Integer> getSortedWordFrequencies() {
		return new TreeMap<>(wordFrequencies);
	}

}
