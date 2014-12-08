package xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLDocument {
	private DocumentBuilder myDocumentBuilder;
	private Document myXMLDocument;
	public XMLDocument(String path){
		try {
			myDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			myXMLDocument = myDocumentBuilder.parse(new File("data/cves.xml"));
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
	public NodeList getNodesByName(String id){
		NodeList ret;
		
		ret = myXMLDocument.getElementsByTagName(id);
		
		return ret;
	}
	public HashMap<Element, NodeList> getChildElementsByName(NodeList l, String id){
		HashMap<Element, NodeList> ret = new HashMap<Element, NodeList>();
		
		for (int i = 0; i < l.getLength(); i++) {
			Node n = l.item(i);
			if(n.getNodeType() == Node.ELEMENT_NODE){
				Element e = (Element) n;
				NodeList childElements = e.getElementsByTagName(id);
				if(childElements.getLength() != 0)
					ret.put(e, childElements);
			}
		}
		
		return ret;
	}
}
