package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TxtTextExtractor {
	public String extractText(String filename) throws Exception {
		File file = new File(filename);
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}

		} catch (IOException e) {
			throw new Exception("Error extracting the text from the txt-File: " + filename, e);
		}

		return content.toString();

	}

}
