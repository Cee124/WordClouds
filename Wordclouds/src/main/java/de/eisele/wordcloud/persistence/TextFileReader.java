package de.eisele.wordcloud.persistence;

import java.util.Scanner;
import java.io.*;

public class TextFileReader {

	public String readTextFile(String filename) {
		StringBuilder sb = new StringBuilder();
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				sb.append(line).append(" ");

			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("Die gesuchte Datei konnte nicht gefunden werden");
		}

		sb.trimToSize();

		return sb.toString();
	}
}
