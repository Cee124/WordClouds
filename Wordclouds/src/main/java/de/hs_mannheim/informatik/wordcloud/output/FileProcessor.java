package de.hs_mannheim.informatik.wordcloud.output;

import java.util.ArrayList;
import java.util.Map;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;
import de.hs_mannheim.informatik.wordcloud.domain.Tokenizer;
import de.hs_mannheim.informatik.wordcloud.domain.WordFrequency;
import de.hs_mannheim.informatik.wordcloud.service.extractor.*;
import de.hs_mannheim.informatik.wordcloud.service.tokenizer.LuceneTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileProcessor {
	private static final Logger logger = LoggerFactory.getLogger(FileProcessor.class);
	private String folderPath;
	private Stopwords stopwords;
	private Tokenizer tokenizer;
	private FolderExtractor folderExtract;
	private WordFrequency wordFrequency;

	public FileProcessor(String folderPath, Stopwords stopwords, String language) {
		this.folderPath = folderPath;
		this.stopwords = stopwords;
		this.wordFrequency = new WordFrequency();
		this.tokenizer = new Tokenizer(stopwords, language, this.wordFrequency);
		this.folderExtract = new FolderExtractor();
	}

	public void processFiles(String outputHtml, String outputCSV, boolean showFrequencies, int minimumFrequencies,
			boolean sortFrequencies, boolean toLowercase, boolean groupWords, int maxWords) throws Exception {

		ArrayList<String> allFiles = folderExtract.getAllFiles(folderPath);

		for (String filepath : allFiles) {
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

		HTMLWriter htmlWriter = new HTMLWriter();
		CSVWriter csvWriter = new CSVWriter();
		csvWriter.writeWordFrequenciesToCSV(wordFrequencies, outputCSV, maxWords);
		htmlWriter.writeTagCloud(outputHtml, wordFrequencies, showFrequencies, minimumFrequencies, maxWords);
		int totalWords = 0;
		for (int freq : wordFrequencies.values()) {
		    totalWords += freq;
		}

		int uniqueWords = wordFrequencies.size();
		System.out.println();
		logger.info("STATISTIK:");
		logger.info("Gesamtzahl der Wörter: " + totalWords);
		logger.info("Anzahl unterschiedlicher Wörter: " + uniqueWords);
	}

	private void processWithoutStemming(String text, boolean toLowercase) {
		if (toLowercase) {
			text = text.toLowerCase();
		}

		String[] tokens = text.split("[^a-zA-ZäöüßÄÖÜ\\-]+");

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

	
}
