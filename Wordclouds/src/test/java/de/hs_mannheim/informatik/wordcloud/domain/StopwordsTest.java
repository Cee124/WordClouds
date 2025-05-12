package de.hs_mannheim.informatik.wordcloud.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StopwordsTest {

	private Stopwords stopword;

	@BeforeEach
	public void setup() {
		stopword = new Stopwords();
	}

	@Test
	void testeAddStopwords() {
		
		stopword.addStopword("Hallo");
		assertNotNull(stopword.getStopwords()); 
		assertTrue(stopword.getStopwords().contains("hallo")); 
	}

	@Test
	void testeGetStopwords() {
		stopword.addStopword("Hallo");
		stopword.addStopword("Beispiel");

		
		assertTrue(stopword.getStopwords().contains("hallo"));
		assertTrue(stopword.getStopwords().contains("beispiel"));
	}

	@Test
	void testeIsStopword() {
		stopword.addStopword("Hallo");

		
		assertTrue(stopword.isStopword("hallo"));
		assertFalse(stopword.isStopword("Beispiel"));
	}
}
