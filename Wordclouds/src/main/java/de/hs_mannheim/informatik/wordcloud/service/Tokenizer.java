package de.hs_mannheim.informatik.wordcloud.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import de.hs_mannheim.informatik.wordcloud.domain.StopwordsManager;
import org.apache.lucene.analysis.TokenStream;
import java.io.IOException;
import java.util.ArrayList;

public class Tokenizer {

	private StopwordsManager stopwordsManager;

	public Tokenizer(StopwordsManager stopwordsManager) {
		this.stopwordsManager = stopwordsManager;
	}

	// Methode zum Tokenisieren und Filtern der Stoppwörter
	public ArrayList<String> tokenize(String text) {
		ArrayList<String> tokens = new ArrayList<>();

		try (Analyzer analyzer = new GermanAnalyzer()) {
			TokenStream tokenStream = analyzer.tokenStream(null, text);
			CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);

			tokenStream.reset();
			while (tokenStream.incrementToken()) {
				String token = termAttribute.toString();

				if (!stopwordsManager.isStopword(token)) {

					tokens.add(token);
				}
			}

			tokenStream.end();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tokens;
	}
}
