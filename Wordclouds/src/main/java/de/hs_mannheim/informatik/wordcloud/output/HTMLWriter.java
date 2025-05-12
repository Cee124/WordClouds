package de.hs_mannheim.informatik.wordcloud.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HTMLWriter {

	public void writeTagCloud(String outputHtmlPath, Map<String, Integer> wordFrequency, boolean showFrequencies,
			int minimumFrequency, int maxWords) throws IOException {

		ArrayList<String> lines = new ArrayList<>();

		// HTML-Datei einlesen
		try (BufferedReader reader = new BufferedReader(new FileReader(outputHtmlPath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			throw new IOException("Error reading the HTML-File: " + e.getMessage());
		}

		ArrayList<String> beforeTagCloud = new ArrayList<>();
		ArrayList<String> afterTagCloud = new ArrayList<>();
		boolean foundPlaceholder = false;

		for (String line : lines) {
			if (!foundPlaceholder) {
				beforeTagCloud.add(line);
				if (line.contains("<!-- TODO: Hier die generierten Tags einsetzen -->")) {
					foundPlaceholder = true;
				}
			} else {
				afterTagCloud.add(line);
			}
		}

		// Datei neu schreiben
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputHtmlPath))) {
			// Alles vor dem Platzhalter schreiben
			for (String line : beforeTagCloud) {
				writer.write(line);
				writer.newLine();
			}

			int id = 1;
			int count = 0;
			for (String word : wordFrequency.keySet()) {
				StringBuilder builder = new StringBuilder();
				int frequency = wordFrequency.get(word);
				if (frequency < minimumFrequency) {
					continue;
				}
				String weight = getClassForWeight(wordFrequency.get(word));
				String url = "https://www.google.com/search?q=" + word;

				builder.append("<span id=\"").append(id++).append("\" class=\"wrd ").append(weight)
						.append("\"><a href=\"").append(url).append("\">").append(word).append("</a></span>");

				if (showFrequencies) {
					builder.append(" (" + wordFrequency.get(word) + ")");
				}

				writer.write(builder.toString());
				writer.newLine();
				

				if (++count >= maxWords) {
					break;
				}
			}

			writer.write("</div>");
			writer.newLine();
			writer.write("</body></html>");

		} catch (IOException e) {
			throw new IOException("Fehler beim Schreiben der Datei: " + e.getMessage());
		}
	}

	private String getClassForWeight(int weight) {

		if (weight >= 50) {
			return "tagcloud10";
		} else if (weight >= 45) {
			return "tagcloud9";
		} else if (weight >= 40) {
			return "tagcloud8";
		} else if (weight >= 35) {
			return "tagcloud7";
		} else if (weight >= 30) {
			return "tagcloud6";
		} else if (weight >= 25) {
			return "tagcloud5";
		} else if (weight >= 20) {
			return "tagcloud4";
		} else if (weight >= 15) {
			return "tagcloud3";
		} else if (weight >= 10) {
			return "tagcloud2";
		} else if (weight >= 5) {
			return "tagcloud1";
		} else {
			return "tagcloud0";
		}

	}

}
