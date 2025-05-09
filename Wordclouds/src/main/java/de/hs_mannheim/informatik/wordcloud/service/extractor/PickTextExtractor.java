package de.hs_mannheim.informatik.wordcloud.service.extractor;

public class PickTextExtractor {
	
	public String textExtractor(String filename) throws Exception {
		
		if(filename.endsWith(".txt")) {
			TxtTextExtractor txtExtractor = new TxtTextExtractor();
			return txtExtractor.extractText(filename);
		} else if (filename.endsWith(".pdf")){
			PdfTextExtractor pdfExtractor = new PdfTextExtractor();
			return pdfExtractor.extractText(filename);
			
		}
		
		return null;
		
		
	}
	
	
	
}
