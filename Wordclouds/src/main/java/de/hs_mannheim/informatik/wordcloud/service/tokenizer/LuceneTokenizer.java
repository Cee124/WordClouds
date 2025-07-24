package de.hs_mannheim.informatik.wordcloud.service.tokenizer;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.de.GermanAnalyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import de.hs_mannheim.informatik.wordcloud.domain.Tokenizer;

public class LuceneTokenizer {
	
	public static void tokenize(Tokenizer tokenize, String text, boolean toLowercase) {
		
		if (toLowercase) {
			text = text.toLowerCase();
		}

		Analyzer analyzer = tokenize.getLanguage().equalsIgnoreCase("german") ? new GermanAnalyzer() : new EnglishAnalyzer();

		try (TokenStream tokenStream = analyzer.tokenStream(null, text)) {

			CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
			tokenStream.reset();
			while (tokenStream.incrementToken()) {
				String token = termAttribute.toString();

				if (!tokenize.getStopwords().isStopword(token)) {
					tokenize.getWordFrequency().addFrequencies(token);

				}
			}

			tokenStream.end();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
