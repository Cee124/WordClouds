package de.hs_mannheim.informatik.wordcloud.ui;



import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.output.TextProcessor;

public class Main {

	public static void main(String[] args) throws Exception {

		String filename = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources";

		String stopwordsFile = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\stopwords.txt";
		try {
		Stopwords stopword = new Stopwords();
		stopword.loadStopwordsFromFile(stopwordsFile);

		stopword.addStopword();

		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2 Wordcloud.html";
		String language = "german";
		TextProcessor textProcess = new TextProcessor(filename, stopword, language);
		
		
		textProcess.processFiles(filename, outputHtmlPath);
			
		} catch (NullPointerException e) {
			System.out.println("Die gesuchte Datei konnte nicht gefunden werden");
		}
		
		
	}

}
