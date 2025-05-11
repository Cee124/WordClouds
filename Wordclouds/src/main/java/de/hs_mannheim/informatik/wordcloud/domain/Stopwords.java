package de.hs_mannheim.informatik.wordcloud.domain;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Stopwords {

	private ArrayList<String> stopwords;

	public Stopwords() {
		stopwords = new ArrayList<>();
	}

	public void loadStopwordsFromFile(String filename) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String word = line.trim().toLowerCase();
				if (!word.isEmpty()) {
					stopwords.add(word);
				}
			}
		}
	}

	public void addStopword() {

		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.println(
					"Gebe ein Stopwort ein, sobald sie 1 eingeben werden alle Wörter hinzugefügt und die Eingabe beendet");

			String line = in.nextLine();
			if (line.equals("1")) {
				System.out.println("Stopwörter hinzugefügt");
				break;
			}

			stopwords.add(line);

		}
		in.close();

	}

	public boolean isStopword(String word) {
		return stopwords.contains(word.toLowerCase());
	}

	public ArrayList<String> getStopwords() {
		return stopwords;
	}
}
