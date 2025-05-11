package de.hs_mannheim.informatik.wordcloud.ui;

import java.io.IOException;
import de.hs_mannheim.informatik.wordcloud.facade.WordCloudGenerator;

public class Main {

	public static void main(String[] args) throws Exception {

		String folderPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources";
		String stopwordsFile = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\stopwords.txt";
		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2Wordcloud.html";
		UserInputHandler handler = new UserInputHandler();
		handler.startFromConsole();
		
		
		
	}
}
