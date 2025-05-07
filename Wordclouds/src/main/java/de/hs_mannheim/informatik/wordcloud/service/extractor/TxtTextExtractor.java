package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.hs_mannheim.informatik.wordcloud.domain.TextExtractor;

public class TxtTextExtractor implements TextExtractor {

	@Override
	public String extractText(File file) throws Exception {
		StringBuilder content = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}

		} catch (IOException e) {
			throw new Exception("Fehler beim Lesen der Datei: " + file.getName(), e);
		}
		
		return content.toString();

	}

}
