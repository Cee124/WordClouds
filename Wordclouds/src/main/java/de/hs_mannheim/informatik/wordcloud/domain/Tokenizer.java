package de.hs_mannheim.informatik.wordcloud.domain;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.TokenStream;
import java.io.IOException;
import java.util.ArrayList;

public class Tokenizer {

	private Stopwords stopwordsManager;

	private String language;
	public Tokenizer(Stopwords stopwordsManager, String language) {
		
		this.stopwordsManager = stopwordsManager;
		this.language = language;
		
	}

	public ArrayList<String> tokenize(String text) {
		ArrayList<String> tokens = new ArrayList<>();
		Analyzer analyzer = language.equalsIgnoreCase("german") ? new GermanAnalyzer() : new EnglishAnalyzer();
		try (TokenStream tokenStream = analyzer.tokenStream(null, text)) {
			
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}