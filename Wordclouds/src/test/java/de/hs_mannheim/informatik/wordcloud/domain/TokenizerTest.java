package de.hs_mannheim.informatik.wordcloud.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TokenizerTest {

	private Tokenizer tokenizer;
	private Stopwords stopwords;
	private WordFrequency wordFrequency;

	@BeforeEach
	public void setup() {

		stopwords = new Stopwords();
		wordFrequency = new WordFrequency();
		tokenizer = new Tokenizer(stopwords, "German", wordFrequency);
	}

	@Test
	public void testTokenizerConstructor() {

		assertNotNull(tokenizer);
	}

	@Test
	public void testGetLanguage() {

		assertEquals("German", tokenizer.getLanguage());
	}

	@Test
	public void testGetWordFrequency() {

		assertNotNull(tokenizer.getWordFrequency());
	}

	@Test
	public void testGetStopwords() {
		assertNotNull(tokenizer.getStopwords());
	}

}
