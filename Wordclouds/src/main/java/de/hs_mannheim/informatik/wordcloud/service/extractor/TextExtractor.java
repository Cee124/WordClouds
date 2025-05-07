package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;

public interface TextExtractor {

	String extractText(String filename) throws Exception;
	
}
