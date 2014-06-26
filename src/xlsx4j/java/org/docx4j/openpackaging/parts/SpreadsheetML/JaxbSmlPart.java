package org.docx4j.openpackaging.parts.SpreadsheetML;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.Binder;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.dom.DOMResult;

import org.docx4j.XmlUtils;
import org.docx4j.jaxb.JAXBAssociation;
import org.docx4j.jaxb.JaxbValidationEventHandler;
import org.docx4j.jaxb.XPathBinderAssociationIsPartialException;
import org.docx4j.openpackaging.contenttype.ContentTypes;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.exceptions.PartUnrecognisedException;
import org.docx4j.openpackaging.io3.stores.PartStore;
import org.docx4j.openpackaging.parts.JaxbXmlPart;
import org.docx4j.openpackaging.parts.JaxbXmlPartXPathAware;
import org.docx4j.openpackaging.parts.Part;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.XPathEnabled;
import org.w3c.dom.Node;
import org.xlsx4j.jaxb.Context;

public abstract class JaxbSmlPart<E>  extends JaxbXmlPartXPathAware<E>  {

	public JaxbSmlPart(PartName partName) throws InvalidFormatException {
		super(partName);
		setJAXBContext(Context.jcSML);						
	}

	public JaxbSmlPart() throws InvalidFormatException {
		super(new PartName("/xl/blagh.xml"));
		setJAXBContext(Context.jcSML);						
	}

	public static Part newPartForContentType(String contentType, String partName)
	throws InvalidFormatException, PartUnrecognisedException {
				
		if (contentType.equals(ContentTypes.SPREADSHEETML_PRINTER_SETTINGS)) {
			return new PrinterSettings(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_STYLES)) {
			return new Styles(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_WORKSHEET)) {
			return new WorksheetPart(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_CALC_CHAIN)) {
			return new CalcChain(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_SHARED_STRINGS)) {
			return new SharedStrings(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_PIVOT_TABLE)) {
			return new PivotTable(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_PIVOT_CACHE_DEFINITION)) {
			return new PivotCacheDefinition(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_PIVOT_CACHE_RECORDS)) {
			return new PivotCacheRecords(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_COMMENTS)) {
			return new CommentsPart(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_CONNECTIONS)) {
			return new ConnectionsPart(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_TABLE)) {
			return new TablePart(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_QUERY_TABLE)) {
			return new QueryTablePart(new PartName(partName));
		} else if (contentType.equals(ContentTypes.SPREADSHEETML_EXTERNAL_LINK)) {
			return new ExternalLinkPart(new PartName(partName));
		} else {
			throw new PartUnrecognisedException("No subclass found for "
					+ partName + " (content type '" + contentType + "')");
		}
	}	
	
	
	

	
}
