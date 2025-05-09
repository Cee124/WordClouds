package de.hs_mannheim.informatik.wordcloud.domain;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.TreeMap;

public class WordFrequency {

	private static HashMap<String, Integer> wordFrequencies;
	private static TreeMap<String, Integer> sortedWordFrequencies;
	public WordFrequency() {
		wordFrequencies = new HashMap<>();
		sortedWordFrequencies = new TreeMap<>();
	}

	public HashMap<String, Integer> getWordFrequencies() {
		return wordFrequencies;
	}

	public void addFrequencies(ArrayList<String> words) {
		for (String w : words) {

			wordFrequencies.put(w, wordFrequencies.getOrDefault(w, 0) + 1);
			sortedWordFrequencies.put(w, sortedWordFrequencies.getOrDefault(w, 0)+1);
		}

	}
	
	public TreeMap<String, Integer> getSortedWordFrequencies() {
		return sortedWordFrequencies;
	}

}
