package de.hs_mannheim.informatik.wordcloud.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import de.hs_mannheim.informatik.wordcloud.domain.StopwordsManager;
import de.hs_mannheim.informatik.wordcloud.output.HTMLWriter;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TextExtractor;

public class TextProcessingService {

	public  HashMap<String, Integer> wordFrequency;
	private TextExtractor textExtractor;
	private StopwordsManager stopwordsManager;
	private Tokenizer tokenizer;

	public TextProcessingService(TextExtractor textExtractor, StopwordsManager stopwordsManager, Tokenizer tokenizer) {
		this.textExtractor = textExtractor;
		wordFrequency = new HashMap<>();
		this.stopwordsManager = stopwordsManager;
		this.tokenizer = tokenizer;
	}

	public void processText(String filename, String outputHtmlPath) {
		
		try {

			String text = textExtractor.extractText(filename);
			ArrayList<String> tokens = tokenizer.tokenize(text);

			for (String token : tokens) {
				if (!stopwordsManager.isStopword(token)) {
					wordFrequency.put(token, wordFrequency.getOrDefault(token, 0) + 1);
				}
			}
			HTMLWriter.writeTagCloud(filename, outputHtmlPath, wordFrequency);
			

		} catch (IOException e) {

			System.err.println("Fehler beim Verarbeiten der Datei: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {

			System.err.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public HashMap<String, Integer> getWordFrequency() {
		return wordFrequency;
	}

}
