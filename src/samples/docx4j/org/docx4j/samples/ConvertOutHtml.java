/*
 *  Copyright 2007-2014, Plutext Pty Ltd.
 *
 *  This file is part of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.

    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package org.docx4j.samples;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.docx4j.Docx4J;
import org.docx4j.Docx4jProperties;
import org.docx4j.convert.out.HTMLSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 * This sample uses XSLT (and Xalan) to
 * produce HTML output.  (There is also
 * HtmlExporterNonXSLT for environments where
 * that is not desirable eg Android).
 *
 * If the source docx contained a WMF, that
 * will get converted to inline SVG.  In order
 * to see the SVG in your browser, you'll need
 * to rename the file to .xml or serve
 * it with MIME type application/xhtml+xml
 *
 */
public class ConvertOutHtml extends AbstractSample {

	// Config for non-command line version
	static {
	
    	inputfilepath = System.getProperty("user.dir") + "/sample-docs/word/sample-docxv2.docx";

		save = false;
	}

	static boolean save;

    public static void main(String[] args)
            throws Exception {
    	
		try {
			getInputFilePath(args);
		} catch (IllegalArgumentException e) {
		}
		
		// Document loading (required)
		WordprocessingMLPackage wordMLPackage;
		if (inputfilepath==null) {
			// Create a docx
			System.out.println("No imput path passed, creating dummy document");
			 wordMLPackage = WordprocessingMLPackage.createPackage();
			SampleDocument.createContent(wordMLPackage.getMainDocumentPart());	
		} else {
			System.out.println("Loading file from " + inputfilepath);
			wordMLPackage = Docx4J.load(new java.io.File(inputfilepath));
		}

		// HTML exporter setup (required)
		// .. the HTMLSettings object
    	HTMLSettings htmlSettings = Docx4J.createHTMLSettings();

    	htmlSettings.setImageDirPath(inputfilepath + "_files");
    	htmlSettings.setImageTargetUri(inputfilepath.substring(inputfilepath.lastIndexOf("/")+1)
    			+ "_files");
    	htmlSettings.setWmlPackage(wordMLPackage);
    	
    	
    	/* CSS reset, see http://itumbcom.blogspot.com.au/2013/06/css-reset-how-complex-it-should-be.html 
    	 * 
    	 * motivated by vertical space in tables in Firefox and Google Chrome.
        
	        If you have unwanted vertical space, in Chrome this may be coming from -webkit-margin-before and -webkit-margin-after
	        (in Firefox, margin-top is set to 1em in html.css)
	        
	        Setting margin: 0 on p is enough to fix it.
	        
	        See further http://www.css-101.org/articles/base-styles-sheet-for-webkit-based-browsers/    	
    	*/
    	String userCSS = "html, body, div, span, h1, h2, h3, h4, h5, h6, p, a, img,  ol, ul, li, table, caption, tbody, tfoot, thead, tr, th, td " +
    			"{ margin: 0; padding: 0; border: 0;}" +
    			"body {line-height: 1;} ";
    	htmlSettings.setUserCSS(userCSS);
    	
    	
    	//Other settings (optional)
//    	htmlSettings.setUserBodyTop("<H1>TOP!</H1>");
//    	htmlSettings.setUserBodyTail("<H1>TAIL!</H1>");
		
		// Sample sdt tag handler (tag handlers insert specific
		// html depending on the contents of an sdt's tag).
		// This will only have an effect if the sdt tag contains
		// the string @class=XXX
//			SdtWriter.registerTagHandler("@class", new TagClass() );
		
//		SdtWriter.registerTagHandler(Containerization.TAG_BORDERS, new TagSingleBox() );
//		SdtWriter.registerTagHandler(Containerization.TAG_SHADING, new TagSingleBox() );
		
		// output to an OutputStream.		
		OutputStream os; 
		if (save) {
			os = new FileOutputStream(inputfilepath + ".html");
		} else {
			os = new ByteArrayOutputStream();
		}

		// If you want XHTML output
    	Docx4jProperties.setProperty("docx4j.Convert.Out.HTML.OutputMethodXML", true);

		//Don't care what type of exporter you use
//		Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_NONE);
		//Prefer the exporter, that uses a xsl transformation
		Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
		//Prefer the exporter, that doesn't use a xsl transformation (= uses a visitor)
//		Docx4J.toHTML(htmlSettings, os, Docx4J.FLAG_EXPORT_PREFER_NONXSL);

		if (save) {
			System.out.println("Saved: " + inputfilepath + ".html ");
		} else {
			System.out.println( ((ByteArrayOutputStream)os).toString() );
		}

    }
    
//    class ResettingStyleHandler implements ConversionHTMLStyleElementHandler {
//
//    	@Override
//    	public Element createStyleElement(OpcPackage opcPackage, Document document,
//    			String styleDefinition) {
//
//    		
//    		if ((styleDefinition != null) && (styleDefinition.length() > 0)) {
//        		
//    			Element ret = document.createElement("link");
//    			ret.setAttribute("rel", "stylesheet");
//    			ret.setAttribute("type", "text/css");
//    			// TODO insert styleDefinition
//        		return ret;
//        		
//    		} else {
//        		System.out.println("styleDefinition was null or empty!");			
//    		}
//    		return null;
//    	}
//    }
    
    
}