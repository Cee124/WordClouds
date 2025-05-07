package de.hs_mannheim.informatik.wordcloud.domain;

import java.io.File;

public interface TextExtractor {

	String extractText(File file) throws Exception;
	
}
