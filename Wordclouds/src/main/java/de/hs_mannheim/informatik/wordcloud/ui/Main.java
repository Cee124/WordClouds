package de.hs_mannheim.informatik.wordcloud.ui;


import de.hs_mannheim.informatik.wordcloud.domain.StopwordsManager;
import de.hs_mannheim.informatik.wordcloud.service.*;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TextExtractor;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TextExtractorFactory;

public class Main {
	public static void main(String[] args) throws Exception {
		
		String filename = "C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\input.txt";
		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2 Wordcloud.html";
		TextExtractor textExtractor = TextExtractorFactory.getExtractor(filename);
		StopwordsManager stopwordsManager = new StopwordsManager();
		
		Tokenizer tokenizer = new Tokenizer(stopwordsManager);
		
		TextProcessingService textProcessingService = new TextProcessingService(textExtractor, stopwordsManager, tokenizer);
		
		textProcessingService.processText(filename, outputHtmlPath);
		
		System.out.println("Die Wordcloud wurde erstellt");
		
		
		
		
		
		
		
		
		
		
		

	}
}
