package de.eisele.wordcloud.persistence;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFileExtractor {

	public String readPDFFile(File pdfFile) {
		String text="";
		try (PDDocument document = PDDocument.load(pdfFile)) {
			PDFTextStripper pdfStripper = new PDFTextStripper();
			text = pdfStripper.getText(document);
			System.out.println(text);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;

	}
	
}
