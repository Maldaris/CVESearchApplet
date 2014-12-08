package xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.*;

public class CVEDocument extends XMLDocument{

	public CVEDocument(String path) {
		super(path);
	}
	public ArrayList<Node> descContains(String s){
		ArrayList<Node> ret = new ArrayList<Node>();
		NodeList nl = this.getNodesByName("item");
		if(nl.getLength() == 0)
			return null;
		for(int i = 0; i < nl.getLength(); i++){
			HashMap<Element, NodeList> h = this.getChildElementsByName(nl, "desc");
			for(Element e: h.keySet()){
				String desc = h.get(e).item(0).getNodeValue();
				if(desc.matches(s))
					ret.add(nl.item(i));
			}
		}
		return ret;
	}
	public HashMap<String, URL> getItemURLS(Node n){
		HashMap<String, URL> ret = new HashMap<String, URL>();
		
		
		
		return ret;
	}
	
}
