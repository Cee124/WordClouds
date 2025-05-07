package de.hs_mannheim.informatik.wordcloud.ui;

import java.io.File;

import de.hs_mannheim.informatik.wordcloud.service.*;
import de.hs_mannheim.informatik.wordcloud.service.extractor.PdfTextExtractor;

public class Main {
	public static void main(String[] args) throws Exception {
		PdfTextExtractor extractor = new PdfTextExtractor();

		File file = new File(
				"C:\\Users\\chris\\git\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\The_Foundations_of_Geometry.pdf");

		try {
			String text = extractor.extractText(file);
			System.out.println(text);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
