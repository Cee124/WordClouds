package de.hs_mannheim.informatik.wordcloud.service.loader;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.service.extractor.TxtTextExtractor;

public class StopwordsLoader {
	public static void loadStopwordsFromFile(String filename, Stopwords stopWords) throws Exception {

		TxtTextExtractor extractor = new TxtTextExtractor();
		String content = extractor.extractText(filename);

		for (String w : content.split("\\W+")) {
			String word = w.trim().toLowerCase();
			if (!word.isEmpty()) {
				stopWords.addStopword(word);
			}
		}

	}
}
