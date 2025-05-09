package de.hs_mannheim.informatik.wordcloud.ui;



import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.output.TextProcessor;

public class Main {

	public static void main(String[] args) throws Exception {

		String filename = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resource";

		String stopwordsFile = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\stopwords.txt";
		try {
		Stopwords stopword = new Stopwords();
		stopword.loadStopwordsFromFile(stopwordsFile);

		stopword.addStopword();

		String outputHtmlPath = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\PR2 Wordcloud.html";
		TextProcessor textProcess = new TextProcessor(filename, stopword);
		
		
		textProcess.processFiles(filename, outputHtmlPath);
			
		} catch (NullPointerException e) {
			System.out.println("Die gesuchte Datei konnte nicht gefunden werden");
		}
		
		
	}

}
