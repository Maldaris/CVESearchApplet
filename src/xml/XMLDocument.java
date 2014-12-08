package xml;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLDocument {
	private DocumentBuilder myDocumentBuilder;
	private Document myXMLDocument;
	public XMLDocument(String path){
		try {
			myDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myXMLDocument = myDocumentBuilder.parse(new File("data/cves.xml"));
		
	}
}
