package de.hs_mannheim.informatik.wordcloud.ui;

import java.io.File;
import java.util.Scanner;

import de.hs_mannheim.informatik.wordcloud.facade.WordCloudGenerator;

public class UserInputHandler {
	private static final String outputHtmlPath = "C:\\Users\\chris\\git\\WordClouds-Repo\\WordClouds-Repo\\Wordclouds\\src\\main\\resources\\PR2Wordcloud.html"; 
	public void startFromConsole() {
		Scanner in = new Scanner(System.in);
		try {

			String folderPath;
			while (true) {
				System.out.print("Gib den Pfad zum Ordner mit den Textdateien ein: ");
				folderPath = in.nextLine().trim();
				File folder = new File(folderPath);
				if (folder.exists() && folder.isDirectory()) {
					break;

				} else {
					System.out.println("Ungültiger Pfad. Bitte gib einen existierenden Ordnerpfad an.");
				}
			}

			String stopwordsFile;
			while (true) {
				System.out.print("Gib den Pfad zur Stopwort-Datei ein: ");
				stopwordsFile = in.nextLine().trim();

				File file = new File(stopwordsFile);
				if (file.exists() && file.isFile()) {
					break; 
				} else {
					System.out.println("Ungültiger Pfad. Bitte gib eine existierende Datei an.");
				}
			}


			String language = "";
			while (true) {
				System.out.print("Bitte gib die Sprache für die WordCloud ein ('English' oder 'German'): ");
				language = in.nextLine().trim();
				if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("German")) {
					break;
				} else {
				System.out.println("Ungültige Eingabe. Bitte gib entweder 'English' oder 'German' ein.");
				}
			}

			boolean showFrequencies;
			while (true) {
				System.out.print("Möchtest du die Häufigkeit der Wörter anzeigen? (ja/nein): ");
				String input = in.nextLine().trim();
				if (input.equalsIgnoreCase("ja")) {
					showFrequencies = true;
					break;
				} else if (input.equalsIgnoreCase("nein")) {
					showFrequencies = false;
					break;
				} else {
				System.out.println("Ungültige Eingabe. Bitte gib 'ja' oder 'nein' ein.");
				}
			}

			int minFreq = -1;
			while (true) {
				System.out.print("Gib die minimale Häufigkeit für Wörter an (z.B. 1): ");
				try {
					minFreq = Integer.parseInt(in.nextLine().trim());
					if (minFreq > 0) {
						break;
					} else {
					System.out.println("Die Häufigkeit muss eine positive Zahl sein.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
				}
			}

			boolean sortFreq;
			while (true) {
				System.out.print("Möchtest du die Worte alphabetisch sortieren? (ja/nein): ");
				String input = in.nextLine().trim();
				if (input.equalsIgnoreCase("ja")) {
					sortFreq = true;
					break;
				} else if (input.equalsIgnoreCase("nein")) {
					sortFreq = false;
					break;
				} else {
				System.out.println("Ungültige Eingabe. Bitte gib 'ja' oder 'nein' ein.");
				}
			}

			boolean toLowercase;
			while (true) {
				System.out.print("Soll der Text in Kleinbuchstaben umgewandelt werden? (ja/nein): ");
				String input = in.nextLine().trim();
				if (input.equalsIgnoreCase("ja")) {
					toLowercase = true;
					break;
				} else if (input.equalsIgnoreCase("nein")) {
					toLowercase = false;
					break;
				} else {
				System.out.println("Ungültige Eingabe. Bitte gib 'ja' oder 'nein' ein.");
				}
			}

			boolean groupWords;
			while (true) {
				System.out.print("Möchtest du die Wörter gruppieren? (ja/nein): ");
				String input = in.nextLine().trim();
				if (input.equalsIgnoreCase("ja")) {
					groupWords = true;
					break;
				} else if (input.equalsIgnoreCase("nein")) {
					groupWords = false;
					break;
				} else {
				System.out.println("Ungültige Eingabe. Bitte gib 'ja' oder 'nein' ein.");
				}
			}

			
			WordCloudGenerator generator = new WordCloudGenerator();
			generator.generate(folderPath, stopwordsFile, outputHtmlPath, language, showFrequencies, minFreq, sortFreq,
					toLowercase, groupWords);

			System.out.println("Die WordCloud wurde erfolgreich erstellt!");
		} catch (Exception e) {
			System.err.println("Fehler beim Erstellen der WordCloud: " + e.getMessage());
			e.printStackTrace();
		} finally {
			in.close();
		}
	}
}
