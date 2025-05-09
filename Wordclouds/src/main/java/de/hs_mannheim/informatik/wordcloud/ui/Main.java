package de.hs_mannheim.informatik.wordcloud.ui;

import java.io.IOException;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.output.TextProcessor;

public class Main {

	
	public static void main(String[] args) throws Exception {

		String filename = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources";

		String stopwordsFile = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\stopwords.txt";
		Stopwords stopword = new Stopwords();
		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2Wordcloud.html";
		String language = "german";
		boolean showFrequencies = true;
		int minimumFrequencies = 1;
		
		try {
			
			stopword.loadStopwordsFromFile(stopwordsFile);
			stopword.addStopword();

			
			
			TextProcessor textProcess = new TextProcessor(filename, stopword, language);
			
			textProcess.processFiles(filename, outputHtmlPath, showFrequencies, minimumFrequencies);

			
			Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });
			
		} catch (NullPointerException e) {
			System.out.println("Die gesuchte Datei konnte nicht gefunden werden");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
