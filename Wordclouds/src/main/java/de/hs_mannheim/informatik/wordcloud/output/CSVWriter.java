package de.hs_mannheim.informatik.wordcloud.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CSVWriter {

	public void writeWordFrequenciesToCSV(Map<String, Integer> wordFrequencies, String filename, int maxWords) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

			writer.write("Word,Frequency");
			writer.newLine();

			int count = 0;
			for (String word : wordFrequencies.keySet()) {
				writer.write(word + "," + wordFrequencies.get(word));
				writer.newLine();

				if (++count >= maxWords) {
					break;
				}
			}

			System.out.println("Die CSV-Datei wurde erfolgreich erstellt!");

		} catch (IOException e) {
			System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
		}
	}
}
