package de.hs_mannheim.informatik.wordcloud.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hs_mannheim.informatik.wordcloud.domain.FileValidater;
import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.domain.Tokenizer;
import de.hs_mannheim.informatik.wordcloud.domain.WordFrequency;
import de.hs_mannheim.informatik.wordcloud.service.extractor.*;

public class TextProcessor {

	private String filename;
	private Stopwords stopwords;
	private Tokenizer tokenizer;
	private FileValidater validate;
	private FolderExtractor folderExtract;

	public TextProcessor(String filename, Stopwords stopwords, String language) {
		this.setFilename(filename);
		this.setStopwords(stopwords);
		this.validate = new FileValidater();
		this.tokenizer = new Tokenizer(stopwords, language);
		this.folderExtract = new FolderExtractor();
	}

	public void processFiles(String filename, String outputHtml, boolean showFrequencies, int minimumFrequencies,
			boolean sortFrequencies) throws Exception {
		String lines = "";
		ArrayList<String> tokenizedWords = new ArrayList<>();
		ArrayList<String> allFiles = folderExtract.getAllFiles(filename);
		for (String filepath : allFiles) {
			if (!validate.isValid(filepath)) {

				System.out.println("Ungültiges Dateiformat");

			} else {

				PickTextExtractor extractor = new PickTextExtractor();
				lines = extractor.textExtractor(filepath);
				tokenizedWords = tokenizer.tokenize(lines);
				WordFrequency wordFrequency = new WordFrequency();
				wordFrequency.addFrequencies(tokenizedWords);
				
				Map<String, Integer> wordFrequencies = new HashMap<>();
				if (sortFrequencies) {
					wordFrequencies = wordFrequency.getSortedWordFrequencies();

				} else {
					wordFrequencies = wordFrequency.getWordFrequencies();
				}

				HTMLWriter writer = new HTMLWriter();
				writer.writeTagCloud(outputHtml, wordFrequencies, showFrequencies,
						minimumFrequencies);
				System.out.println("Die WordCloud wurde somit erstellt");

			}
		}

	}

	public Stopwords getStopwords() {
		return stopwords;
	}

	public void setStopwords(Stopwords stopwords) {
		this.stopwords = stopwords;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
