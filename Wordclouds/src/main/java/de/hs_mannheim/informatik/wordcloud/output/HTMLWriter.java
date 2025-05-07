package de.hs_mannheim.informatik.wordcloud.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTMLWriter {

	public static void writeTagCloud(String filename, String outputHtmlPath,
			HashMap<String, Integer> wordFrequency) throws IOException {
		List<String> lines = new ArrayList<>();

		// HTML-Template-Datei einlesen
		try (BufferedReader reader = new BufferedReader(new FileReader(outputHtmlPath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			throw new IOException("Fehler beim Lesen der HTML-Datei: " + e.getMessage());
		}

		List<String> beforeTagCloud = new ArrayList<>();
		boolean foundPlaceholder = false;

		for (String line : lines) {
			beforeTagCloud.add(line);
			if (line.contains("<!-- TODO: Hier die generierten Tags einsetzen -->")) {
				foundPlaceholder = true;
				break;
			}
		}

		if (!foundPlaceholder) {
			throw new IOException(
					"Platzhalter <!-- TODO: Hier die generierten Tags einsetzen --> wurde nicht gefunden.");
		}

		// Neue Datei schreiben
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputHtmlPath))) {
			// Teil vor dem Platzhalter schreiben
			for (String line : beforeTagCloud) {
				writer.write(line);
				writer.newLine();
			}

			// Tags einfügen
			int id = 1;
			for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
				String word = entry.getKey();
				int weight = Math.min(entry.getValue(), 10); // Max. Gewicht 10
				String url = "https://www.google.com/search?q=" + word;

				String tag = String.format("<span id=\"%d\" class=\"wrd tagcloud%d\"><a href=\"%s\">%s</a></span>",
						id++, weight, url, word);

				writer.write(tag);
				writer.newLine();
			}

			// Abschluss der HTML-Datei
			writer.write("</div>");
			writer.newLine();
			writer.write("</body></html>");
		} catch (IOException e) {
			throw new IOException("Fehler beim Schreiben der Datei: " + e.getMessage());
		}
	}
}
