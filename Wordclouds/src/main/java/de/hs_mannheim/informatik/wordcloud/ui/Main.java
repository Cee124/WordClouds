package de.hs_mannheim.informatik.wordcloud.ui;

import de.hs_mannheim.informatik.wordcloud.domain.StopwordsManager;
import de.hs_mannheim.informatik.wordcloud.service.*;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TextExtractor;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TextExtractorFactory;

public class Main {
	public static void main(String[] args) throws Exception {

		String filename = "C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\The_Foundations_of_Geometry.pdf";
		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2 Wordcloud.html";
		String stopwordsFile = "C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\stopwords.txt";
		
		//TextExtractor Auswahl abhängig vom Dateiformat
		TextExtractor textExtractor = TextExtractorFactory.getExtractor(filename);
		
		//StopwordsManager initialisieren und anschließend die stopwords.txt verarbeiten
		StopwordsManager stopwordsManager = new StopwordsManager();
		stopwordsManager.loadStopwordsFromFile(stopwordsFile);

		//Tokenizer mit stopwordsManager als Parameter initialisieren, damit stopwords nicht tokenized werden
		Tokenizer tokenizer = new Tokenizer(stopwordsManager);

		
		//TextProcessingService zur Erstellung der HTML initialisieren
		TextProcessingService textProcessingService = new TextProcessingService(textExtractor, stopwordsManager,
				tokenizer);
		
		//Datei einlesen, verarbeiten, und die HTML umschreiben
		textProcessingService.processText(filename, outputHtmlPath);

		System.out.println("Die Wordcloud wurde erstellt");

	}
}
