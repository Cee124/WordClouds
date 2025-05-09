package de.hs_mannheim.informatik.wordcloud.domain;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.TokenStream;
import java.io.IOException;
import java.util.ArrayList;

public class Tokenizer {

	private Stopwords stopwordsManager;

	public Tokenizer(Stopwords stopwordsManager) {
		this.stopwordsManager = stopwordsManager;
	}

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