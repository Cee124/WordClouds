package de.hs_mannheim.informatik.wordcloud.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.domain.Tokenizer;
import de.hs_mannheim.informatik.wordcloud.domain.WordFrequency;
import de.hs_mannheim.informatik.wordcloud.service.extractor.*;
import de.hs_mannheim.informatik.wordcloud.service.tokenizer.LuceneTokenizer;

public class FileProcessor {

	private String filename;
	private Stopwords stopwords;
	private Tokenizer tokenizer;
	private FileValidater validate;
	private FolderExtractor folderExtract;
	private WordFrequency wordFrequency;

	public FileProcessor(String filename, Stopwords stopwords, String language) {
		this.filename = filename;
		this.stopwords = stopwords;
		this.validate = new FileValidater();
		this.wordFrequency = new WordFrequency();
		this.tokenizer = new Tokenizer(stopwords, language, this.wordFrequency);
		this.folderExtract = new FolderExtractor();
	}

	public void processFiles(String outputHtml, boolean showFrequencies, int minimumFrequencies,
			boolean sortFrequencies, boolean toLowercase, boolean groupWords, int maxWords) throws Exception {

		ArrayList<String> allFiles = folderExtract.getAllFiles(filename);

		for (String filepath : allFiles) {
			if (!validate.isValid(filepath)) {
				System.out.println("Ungültiges Dateiformat: " + filepath);
				continue;
			}

			PickTextExtractor extractor = new PickTextExtractor();
			String text = extractor.textExtractor(filepath);

			if (groupWords) {
				LuceneTokenizer.tokenize(tokenizer, text, toLowercase);
				
			} else {
				processWithoutStemming(text, toLowercase);
			}

		}

		
		Map<String, Integer> wordFrequencies;
		if (sortFrequencies) {
			wordFrequencies = wordFrequency.getSortedWordFrequencies();
		} else {
			wordFrequencies = wordFrequency.getWordFrequencies();
		}

		HTMLWriter writer = new HTMLWriter();
		writer.writeTagCloud(outputHtml, wordFrequencies, showFrequencies, minimumFrequencies, maxWords);
		
	}

	private void processWithoutStemming(String text, boolean toLowercase) {
		if (toLowercase) {
			text = text.toLowerCase();
		}

		String[] tokens = text.split("[^a-zA-ZäöüßÄÖÜ]+");

		for (String token : tokens) {
			if (token.isEmpty() || stopwords.isStopword(token)) {
				continue;
			}
			wordFrequency.addFrequencies(token);
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
