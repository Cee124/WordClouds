package de.hs_mannheim.informatik.wordcloud.facade;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;

import de.hs_mannheim.informatik.wordcloud.output.FileProcessor;
import de.hs_mannheim.informatik.wordcloud.service.loader.StopwordsLoader;

public class WordCloudGenerator {

	private Stopwords stopwords;

	public Stopwords loadStopwords(String filepath) throws Exception {
		this.stopwords = new Stopwords();
		StopwordsLoader.loadStopwordsFromFile(filepath, stopwords);
		return stopwords;
	}

	public void addStopword(String word) {
		
			stopwords.addStopword(word);;
		
	}


	public void generate(String folderPath, String outputHtmlPath, String outputCSVPath, String language,
			boolean showFrequencies, int minimumFrequencies, boolean sortFrequencies, boolean toLowercase,
			boolean groupWords, int maxWords) throws Exception {

		FileProcessor processor = new FileProcessor(folderPath, stopwords, language);
		processor.processFiles(outputHtmlPath, outputCSVPath, showFrequencies, minimumFrequencies, sortFrequencies,
				toLowercase, groupWords, maxWords);

		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });
		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputCSVPath });

	}
}
