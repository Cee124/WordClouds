package de.hs_mannheim.informatik.wordcloud.domain;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordFrequencyTest {

	private WordFrequency wordFrequency;

	@BeforeEach
	public void setup() {
		wordFrequency = new WordFrequency();
	}

	@Test
	void testeGetWordFrequencies() {
		assertTrue(wordFrequency.getWordFrequencies().isEmpty());
	}

	@Test
	void testeAddFrequencies() {

		wordFrequency.addFrequencies("Hallo");
		wordFrequency.addFrequencies("Welt");
		wordFrequency.addFrequencies("Welt");
		wordFrequency.addFrequencies("PR2");
		wordFrequency.addFrequencies("PR2");
		wordFrequency.addFrequencies("PR2");

		assertTrue(wordFrequency.getWordFrequencies().containsKey("Hallo"));
		assertTrue(wordFrequency.getWordFrequencies().containsKey("Welt"));
		assertTrue(wordFrequency.getWordFrequencies().containsKey("PR2"));
		assertEquals(wordFrequency.getWordFrequencies().get("Hallo"), 1);
		assertEquals(wordFrequency.getWordFrequencies().get("Welt"), 2);
		assertEquals(wordFrequency.getWordFrequencies().get("PR2"), 3);

	}

	@Test
	void testeGetSortedWordFrequencies() {

		wordFrequency.addFrequencies("Apfel");
		wordFrequency.addFrequencies("Zitrone");
		wordFrequency.addFrequencies("Banane");
	
		Map<String, Integer> sortedMap = wordFrequency.getSortedWordFrequencies();
		List<String> expectedOrder = List.of("Apfel", "Banane", "Zitrone");
        List<String> actualOrder = new ArrayList<>(sortedMap.keySet());

        assertEquals(expectedOrder, actualOrder);
    }

	}


