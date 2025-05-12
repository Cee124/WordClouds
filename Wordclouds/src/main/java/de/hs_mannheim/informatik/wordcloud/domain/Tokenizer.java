package de.hs_mannheim.informatik.wordcloud.domain;



public class Tokenizer {

	private WordFrequency wordFrequency;
	private String language;
	private Stopwords stopwords;
	public Tokenizer(Stopwords stopwords, String language, WordFrequency wordFrequency) {
		this.stopwords = stopwords;
		this.language = language;
		this.wordFrequency = wordFrequency; 
	
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

	public Stopwords getStopwords() {
		return stopwords;
	}

	public void setStopwords(Stopwords stopwords) {
		this.stopwords = stopwords;
	}
}
