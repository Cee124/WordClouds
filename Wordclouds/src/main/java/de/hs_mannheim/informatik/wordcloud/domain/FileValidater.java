package de.hs_mannheim.informatik.wordcloud.domain;



public class FileValidater {

	public boolean isValid(String filename) {
		boolean isValid = false;

		if (filename.endsWith(".txt") || filename.endsWith(".pdf") || filename.endsWith(".docx")
				|| filename.endsWith(".pptx")) {
			isValid = true;
			
		}

		return isValid;
	}
	
	

}
