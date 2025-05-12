package de.hs_mannheim.informatik.wordcloud.domain;


import java.util.ArrayList;


public class Stopwords {

	private ArrayList<String> stopwords;

	public Stopwords() {
		stopwords = new ArrayList<>();
	}



	

	public ArrayList<String> getStopwords() {
		return stopwords;
	}
	
	public void addStopword(String word) {
		stopwords.add(word.toLowerCase());
	}
	
	public boolean isStopword(String word) {
		return stopwords.contains(word.toLowerCase());
	}
}
