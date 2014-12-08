package xml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

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
	private boolean testMultiple(String[] regexes, String source){
		boolean ret = false;
		for(String s : regexes){
			if(source.matches(s))
				ret = ret || true;
		}
		return ret;
	}
	public HashMap<Element, URL[]> getItemURLs(NodeList targets, Node n){
		HashMap<Element, URL[]> ret = new HashMap<Element, URL[]>();
		
		for(int i = 0; i < targets.getLength(); i++){
			HashMap<Element, NodeList> h = this.getChildElementsByName(targets, "ref");
			Vector<URL> v = new Vector<URL>();
			for(Element e: h.keySet()){
				boolean valid = testMultiple(new String[]{".*CERT-VN.*",".*SECUNIA.*",".*BID.*"}, e.getAttribute("source"));
				if(valid)
					try {
						v.add(new URL(e.getAttribute("url")));
					} catch (MalformedURLException e1) {
						continue;
					}
			}
			if(v.size() != 0){
				ret.put((Element) targets.item(i), v.toArray(new URL[v.size()]));
			}
		}
		return ret;
	}
	
}
