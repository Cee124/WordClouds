package de.hs_mannheim.informatik.wordcloud.facade;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;

import de.hs_mannheim.informatik.wordcloud.output.FileProcessor;
import de.hs_mannheim.informatik.wordcloud.service.loader.StopwordsLoader;

public class WordCloudGenerator {

	public void generate(String folderPath, Stopwords stopwords, String outputHtmlPath, String language,
			boolean showFrequencies, int minimumFrequencies, boolean sortFrequencies, boolean toLowercase,
			boolean groupWords, int maxWords) throws Exception {

		

		FileProcessor processor = new FileProcessor(folderPath, stopwords, language);
		processor.processFiles(outputHtmlPath, showFrequencies, minimumFrequencies, sortFrequencies,
				toLowercase, groupWords, maxWords);

		
		Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "\"\"", outputHtmlPath });

	}
}
