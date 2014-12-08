package xml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CVENode {
	private Node myNode;
	private Element myElement;
	public CVENode(Node n){
		myNode = n;
		myElement = (Element) n;
	}
	public String getName(){
		return myElement.getAttribute("name");
	}
	public String getDescription(){
		return myElement.getElementsByTagName("desc").item(0).getTextContent();
	}
	public URL[] getURLs(){
		Vector<URL> v = new Vector<URL>();
		NodeList children = myNode.getChildNodes();
		
		for(int x = 0; x < children.getLength(); x++){
			Element e = ((Element) children.item(x));
			if(e.getNodeName() == "ref"){
				boolean valid = CVEDocument.testMultiple(new String[]{".*CERT-VN.*",".*SECUNIA.*",".*BID.*"}, e.getAttribute("source"));
				if(valid){
					try {
						v.add(new URL(e.getAttribute("url")));
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
						continue;
					}
				}
			}
		}
		return v.toArray(new URL[v.size()]);
	}
	public static CVENode[] nodeListToArray(NodeList n){
		CVENode[] ret = new CVENode[n.getLength()];
		for(int x = 0; x < n.getLength(); x++)
			ret[x] = new CVENode(n.item(x));
		return ret;
	}
}