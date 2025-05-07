package de.hs_mannheim.informatik.wordcloud.service.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import de.hs_mannheim.informatik.wordcloud.domain.TextExtractor;

public class PptxTextExtractor implements TextExtractor{

	@Override
	public String extractText(File file) throws Exception {
		
		StringBuilder textBuilder = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(file);
             XMLSlideShow ppt = new XMLSlideShow(fis)) {

            for (XSLFSlide slide : ppt.getSlides()) {
                for (XSLFShape shape : slide.getShapes()) {
                    if (shape instanceof XSLFTextShape textShape) {
                        textBuilder.append(textShape.getText()).append("\n");
                    }
                }
            }

        } catch (IOException e) {
        	throw new Exception("Fehler beim Extrahieren von Text aus der PDF-Datei: " + file.getName(), e);
        }

        return textBuilder.toString();
    }
}
