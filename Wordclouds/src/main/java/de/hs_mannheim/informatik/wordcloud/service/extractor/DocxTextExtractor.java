package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import de.hs_mannheim.informatik.wordcloud.domain.TextExtractor;

public class DocxTextExtractor implements TextExtractor {

	@Override
	public String extractText(File file) throws Exception {
		StringBuilder text = new StringBuilder();

		try (FileInputStream fis = new FileInputStream(file);
				XWPFDocument document = new XWPFDocument(fis);
				XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {

			// Extrahieren des Textes und Anhängen an StringBuilder
			text.append(extractor.getText().trim());

		} catch (IOException e) {
			throw new Exception("Fehler beim Extrahieren des Textes aus der DOCX-Datei: " + file.getName(), e);
		}

		return text.toString();
	}
}