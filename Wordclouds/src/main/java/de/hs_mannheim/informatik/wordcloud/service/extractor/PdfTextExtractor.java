package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import de.hs_mannheim.informatik.wordcloud.domain.TextExtractor;

public class PdfTextExtractor implements TextExtractor {

    @Override
    public String extractText(File file) throws Exception {
        StringBuilder text = new StringBuilder();

        try (PDDocument document = PDDocument.load(file)) {
        	PDFTextStripper pdfStripper = new PDFTextStripper();
        	text.append(pdfStripper.getText(document).trim());
        	
        	} catch (Exception e) {
        		throw new Exception("Fehler beim Extrahieren von Text aus der PDF-Datei: " + file.getName(), e);
    }
        return text.toString();
}
}
