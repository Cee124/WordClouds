package de.hs_mannheim.informatik.wordcloud.ui;

import java.io.IOException;
import de.hs_mannheim.informatik.wordcloud.facade.WordCloudGenerator;



public class Main {

	public static void main(String[] args) throws Exception {

		String folderPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources";

		String stopwordsFile = "C:\\Users\\chris\\eclipse-workspace\\WordCloud\\src\\main\\resources\\stopwords.txt";
		
		String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2Wordcloud.html";
		String language = "german";
		boolean showFrequencies = true;
		int minimumFrequencies = 1;
		boolean sortFrequencies = true;
		
        
        try {
            new WordCloudGenerator().generate(folderPath, stopwordsFile, outputHtmlPath, language, showFrequencies, minimumFrequencies, sortFrequencies);

        } catch (IOException e) {
            System.out.println("Fehler beim Verarbeiten der Dateien: " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Ein Fehler ist aufgetreten, weil eine Null-Referenz gefunden wurde: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

	
