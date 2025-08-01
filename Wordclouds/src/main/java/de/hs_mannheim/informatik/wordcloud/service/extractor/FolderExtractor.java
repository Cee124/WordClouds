package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import java.util.ArrayList;

public class FolderExtractor {

	private FileValidater valid = new FileValidater();

	public ArrayList<String> getAllFiles(String path) throws Exception {
		ArrayList<String> allFiles = new ArrayList<>();

		File f = new File(path);
		
			File[] files = f.listFiles();
			for (File file : files) {
				if (!valid.isValid(file.getAbsolutePath())) {
					continue;
				} else {
					allFiles.add(file.getAbsolutePath());

				}

			}
		

		return allFiles;

	}

}
