package de.hs_mannheim.informatik.wordcloud.ui;

import java.util.Scanner;

import de.hs_mannheim.informatik.wordcloud.domain.Stopwords;

public class StopwordsInputHandler {
	public static void addStopwordsFromUserInput(Stopwords stopwords) {
		Scanner in = new Scanner(System.in);
		System.out.println("Gebe Stopwörter ein, die Eingabe wird beendet, wenn du '1' eingibst:");

		while (true) {
			String line = in.nextLine();
			if (line.equals("1")) {
				System.out.println("Stopwörter hinzugefügt.");
				break;
			}
			stopwords.getStopwords().add(line.trim().toLowerCase());
		}
		in.close();
	}
}
