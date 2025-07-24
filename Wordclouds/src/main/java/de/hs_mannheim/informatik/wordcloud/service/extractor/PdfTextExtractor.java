package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfTextExtractor {
	public String extractText(String filename) throws Exception {
    	File file = new File(filename);
        StringBuilder text = new StringBuilder();

        try (PDDocument document = PDDocument.load(file)) {
        	PDFTextStripper pdfStripper = new PDFTextStripper();
        	text.append(pdfStripper.getText(document).trim());
        	
        	} catch (Exception e) {
        		throw new Exception("Error extracting the text from the PDF-File: " + filename, e);
    }
        return text.toString();
}
}


