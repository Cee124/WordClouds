package de.hs_mannheim.informatik.wordcloud.domain;


import java.util.ArrayList;


public class Stopwords {

	private ArrayList<String> stopwordsListe;

	public Stopwords() {
		stopwordsListe = new ArrayList<>();
	}



	

	public ArrayList<String> getStopwords() {
		return stopwordsListe;
	}
	
	public void addStopword(String word) {
		stopwordsListe.add(word.toLowerCase());
	}
	
	public boolean isStopword(String word) {
		return stopwordsListe.contains(word.toLowerCase());
	}
	
}
