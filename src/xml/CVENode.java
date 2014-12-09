package xml;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CVENode {
	private Node myNode;
	private Element myElement;

	public CVENode(Node n) {
		myNode = n;
		myElement = (Element) n;
	}

	public String getName() {
		return myElement.getAttribute("name");
	}

	public String getDescription() {
		return myElement.getElementsByTagName("desc").item(0).getTextContent();
	}

	public boolean matchRegex(Pattern p) {
		if (Pattern.matches(p.pattern(), this.getDescription()))
			return true;
		return false;
	}

	public URL[] getURLs() {
		Vector<URL> v = new Vector<URL>();
		NodeList children = myNode.getChildNodes();

		for (int x = 0; x < children.getLength(); x++) {
			Element e = ((Element) children.item(x));
			if (e.getNodeName() == "ref") {
				boolean valid = CVEDocument.testMultiple(new String[] {
						".*CERT-VN.*", ".*SECUNIA.*", ".*BID.*" },
						e.getAttribute("source"));
				if (valid) {
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

	public static String getURLSource(URL url) {
		String[] validSources = new String[] { ".*CERT-VN.*", ".*SECUNIA.*",
				".*BID.*" };
		for(String source : validSources){
			if(url.toString().matches(source)){
				String ret = source;
				ret = ret.substring(0, 2);
				ret = ret.substring(ret.length()-2, ret.length());
				return ret;
			}
		}
		return null;
	}

	public static CVENode[] nodeListToArray(NodeList n) {
		CVENode[] ret = new CVENode[n.getLength()];
		for (int x = 0; x < n.getLength(); x++)
			ret[x] = new CVENode(n.item(x));
		return ret;
	}

	public String[] toHTML() {
		ArrayList<String> ret = new ArrayList<String>();
		String urlTemplate = "<a href=%0>%1</a>";
		
		ret.add(this.getName());
		ret.add(this.getDescription());
		for(URL url : this.getURLs()){
			String t = urlTemplate.replaceFirst("%0", url.toString());
			t = t.replaceFirst("%1", CVENode.getURLSource(url));
			ret.add(t);
		}
		String[] retarr = new String[ret.size()];
		retarr = ret.toArray(retarr);
		return retarr;
	}

	public static String[] getHTMLStyles() {
		return new String[] { "bold", "regular", "regular" };
	}
}