package de.hs_mannheim.informatik.wordcloud.domain;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.TokenStream;
import java.io.IOException;


public class Tokenizer {

	private Stopwords stopwordsManager;
	private WordFrequency wordFrequency;
	private String language;

	public Tokenizer(Stopwords stopwordsManager, String language, WordFrequency wordFrequency) {
		this.stopwordsManager = stopwordsManager;
		this.language = language;
		this.wordFrequency = wordFrequency; 
	}

	public void tokenize(String text, boolean toLowercase) {
		
		if (toLowercase) {
			text = text.toLowerCase();
		}

		Analyzer analyzer = language.equalsIgnoreCase("german") ? new GermanAnalyzer() : new EnglishAnalyzer();

		try (TokenStream tokenStream = analyzer.tokenStream(null, text)) {

			CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
			tokenStream.reset();
			while (tokenStream.incrementToken()) {
				String token = termAttribute.toString();

				if (!stopwordsManager.isStopword(token)) {
					wordFrequency.addFrequencies(token); 
				
				}
			}

			tokenStream.end();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	

	public WordFrequency getWordFrequency() {
		return wordFrequency;
	}

	public void setWordFrequency(WordFrequency wordFrequency) {
		this.wordFrequency = wordFrequency;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
