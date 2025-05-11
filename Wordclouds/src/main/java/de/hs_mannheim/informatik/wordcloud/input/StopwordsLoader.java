package de.hs_mannheim.informatik.wordcloud.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;

public class StopwordsLoader {
	public void loadStopwordsFromFile(String filename, Stopwords stopWords) throws IOException {
		ArrayList<String> stopwordsFromFile = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String word = line.trim().toLowerCase();
				if (!word.isEmpty()) {
					stopwordsFromFile.add(word);
				}
			}
			
			for(String w: stopwordsFromFile) {
				stopWords.addStopword(w);
			}
			
			
		}
	}
}
