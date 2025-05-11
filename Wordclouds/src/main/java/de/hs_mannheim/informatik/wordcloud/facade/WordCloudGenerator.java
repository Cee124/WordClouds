package de.hs_mannheim.informatik.wordcloud.facade;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.input.StopwordsLoader;
import de.hs_mannheim.informatik.wordcloud.ui.StopwordsInputHandler;
import de.hs_mannheim.informatik.wordcloud.output.FileProcessor;

public class WordCloudGenerator {

	public void generate(String folderPath, String stopwordsPath, String outputHtmlPath, String language,
			boolean showFrequencies, int minimumFrequencies, boolean sortFrequencies, boolean toLowercase,
			boolean groupWords) throws Exception {

		Stopwords stopwords = new Stopwords();

		StopwordsLoader loader = new StopwordsLoader();
		loader.loadStopwordsFromFile(stopwordsPath, stopwords);

		StopwordsInputHandler.addStopwordsFromUserInput(stopwords);

		FileProcessor processor = new FileProcessor(folderPath, stopwords, language);
		processor.processFiles(folderPath, outputHtmlPath, showFrequencies, minimumFrequencies, sortFrequencies,
				toLowercase, groupWords);

		
		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });

	}
}
