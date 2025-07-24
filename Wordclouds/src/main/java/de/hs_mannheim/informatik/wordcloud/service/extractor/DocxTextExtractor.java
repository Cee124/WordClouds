package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;



public class DocxTextExtractor {

	
	public String extractText(String filename) throws Exception {
		StringBuilder text = new StringBuilder();
		File file = new File(filename);
		try (FileInputStream fis = new FileInputStream(file);
				//Klasse aus Apache Poi-Bilbiothek, die zum Bearbeiten und Extrahieren von Inhalten aus Word-Dokumenten im  .docx Format dient
				XWPFDocument document = new XWPFDocument(fis);
				XWPFWordExtractor extractor = new XWPFWordExtractor(document)) {

			
			text.append(extractor.getText().trim());

		} catch (IOException e) {
			throw new Exception("Error extracting the text from the Docx-File: " + filename, e);
		}

		return text.toString();
	}

	
}