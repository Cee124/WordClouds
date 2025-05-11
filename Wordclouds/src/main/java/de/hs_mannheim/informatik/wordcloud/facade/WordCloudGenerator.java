package de.hs_mannheim.informatik.wordcloud.facade;


import java.io.IOException;
import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.ui.StopwordsInputHandler;
import de.hs_mannheim.informatik.wordcloud.output.FileProcessor;

public class WordCloudGenerator {

	public void generate(String folderPath, String stopwordsPath, String outputHtmlPath, String language,
			boolean showFrequencies, int minimumFrequencies, boolean sortFrequencies) throws Exception {

		Stopwords stopwords = new Stopwords();

		try {
			// Stopwords laden
			stopwords.loadStopwordsFromFile(stopwordsPath);

			// Optionale Benutzereingabe (UI-Schicht)
			StopwordsInputHandler.addStopwordsFromUserInput(stopwords);

			// Dateien verarbeiten und HTML erzeugen
			FileProcessor processor = new FileProcessor(folderPath, stopwords, language);
			processor.processFiles(folderPath, outputHtmlPath, showFrequencies, minimumFrequencies, sortFrequencies);

			// HTML-Datei öffnen
			Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });

		} catch (IOException e) {
			System.err.println("Fehler beim Erzeugen der Wordcloud: " + e.getMessage());
		}
	}
}


