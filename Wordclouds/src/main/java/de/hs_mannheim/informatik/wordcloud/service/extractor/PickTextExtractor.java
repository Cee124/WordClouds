package de.hs_mannheim.informatik.wordcloud.service.extractor;

public class PickTextExtractor {

	public String textExtractor(String filename) throws Exception {
		if (filename.endsWith(".txt")) {
			TxtTextExtractor txtExtractor = new TxtTextExtractor();
			return txtExtractor.extractText(filename);
		} else if (filename.endsWith(".pdf")) {
			PdfTextExtractor pdfExtractor = new PdfTextExtractor();
			return pdfExtractor.extractText(filename);
		} else if (filename.endsWith(".docx")) {
			DocxTextExtractor docxExtractor = new DocxTextExtractor();
			return docxExtractor.extractText(filename);
		} else if (filename.endsWith(".pptx")) {
			PptxTextExtractor pptxExtractor = new PptxTextExtractor();
			return pptxExtractor.extractText(filename);
		}

		throw new IllegalArgumentException("Unsupported file format: " + filename);
	}
}
