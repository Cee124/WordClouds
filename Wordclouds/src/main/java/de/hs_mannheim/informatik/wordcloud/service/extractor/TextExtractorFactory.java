package de.hs_mannheim.informatik.wordcloud.service.extractor;



public class TextExtractorFactory {

	public static TextExtractor getExtractor(String filename) {

		String fileName = filename.toLowerCase();

		if (fileName.endsWith(".pdf")) {
			return new PdfTextExtractor();
		} else if (fileName.endsWith(".docx")) {
			return new DocxTextExtractor();
		} else if (fileName.endsWith(".pptx")) {
			return new PptxTextExtractor();
		} else if (fileName.endsWith(".txt")) {
			return new TxtTextExtractor();
		} else {
			throw new IllegalArgumentException("Unsupported file type: " + fileName);
		}
	}
}