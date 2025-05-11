package de.hs_mannheim.informatik.wordcloud.facade;


import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.input.StopwordsLoader;
import de.hs_mannheim.informatik.wordcloud.ui.StopwordsInputHandler;
import de.hs_mannheim.informatik.wordcloud.output.FileProcessor;

public class WordCloudGenerator {

	public void generate(String folderPath, String stopwordsPath, String outputHtmlPath, String language,
			boolean showFrequencies, int minimumFrequencies, boolean sortFrequencies) throws Exception {

		Stopwords stopwords = new Stopwords();

		// Stopwords laden+
		StopwordsLoader loader = new StopwordsLoader();
		loader.loadStopwordsFromFile(stopwordsPath, stopwords);
		

		// Optionale Benutzereingabe (UI-Schicht)
		StopwordsInputHandler.addStopwordsFromUserInput(stopwords);

		// Dateien verarbeiten und HTML erzeugen
		FileProcessor processor = new FileProcessor(folderPath, stopwords, language);
		processor.processFiles(folderPath, outputHtmlPath, showFrequencies, minimumFrequencies, sortFrequencies);

		// HTML-Datei öffnen
		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });

	}
}
