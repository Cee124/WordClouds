package de.hs_mannheim.informatik.wordcloud.domain;

import java.io.*;
import java.util.ArrayList;

public class StopwordsManager {
	private ArrayList<String> stopwords;

	public StopwordsManager() {
		this.stopwords = new ArrayList<>();
	}

	// Methode zum Laden von Stoppwörtern aus einer Datei
	public void loadStopwordsFromFile(String filePath) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String word = line.trim().toLowerCase(); 
				if (!word.isEmpty()) {
					stopwords.add(word);
				}
			}
		}
	}

	public void addStopword(String word) {
		stopwords.add(word.toLowerCase());
	}

	public boolean isStopword(String word) {
		return stopwords.contains(word.toLowerCase()); 
	}

	public ArrayList<String> getStopwords() {
		return stopwords;
	}
}
