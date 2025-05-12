package de.hs_mannheim.informatik.wordcloud.output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CSVWriter {

	public void writeWordFrequenciesToCSV(Map<String, Integer> wordFrequencies, String filename) {
		
		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
           
            writer.println("Word,Frequency");
            
           
            for (String word: wordFrequencies.keySet()) {
                writer.println(word + "," + wordFrequencies.get(word));
            }

            System.out.println("Die CSV-Datei wurde erfolgreich erstellt!");

        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
}



