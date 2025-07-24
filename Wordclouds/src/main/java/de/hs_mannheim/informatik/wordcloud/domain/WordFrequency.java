package de.hs_mannheim.informatik.wordcloud.domain;


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

	public void addFrequencies(String word) {
        wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
    }



	public Map<String, Integer> getSortedWordFrequencies() {
		return new TreeMap<>(wordFrequencies);
	}

}
