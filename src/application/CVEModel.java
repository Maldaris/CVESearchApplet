package application;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.*;
import utilities.CVENodeAlphaComparator;
import xml.*;

public class CVEModel {
	private BinarySearchTree<CVEPriorityQueue> mySearchTree;
	private CVEDocument myCVEDocument;
	private String mySearchString;
	public final Pattern REGEX_CAPITAL = Pattern
			.compile("([A-Z][\\w-]*(\\s+[A-Z][\\w-]*)+)");
	public final Pattern REGEX_RESERVED = Pattern
			.compile("(\\*)(\\*)(\\*)(\\s)RESERVED(\\s)(\\*)(\\*)(\\*)");

	public CVEModel() {
		myCVEDocument = new CVEDocument("data/cve.xml");
		mySearchString = "";
		mySearchTree = buildSearchTree();
	}

	public CVEDocument getCVEDocument() {
		return myCVEDocument;
	}

	public String[] getSearchTerms(CVEDocument d) {
		ArrayList<String> ret = new ArrayList<String>();

		CVENode[] cveNodes = CVENode.nodeListToArray(d.getNodesByName("item"));
		for (CVENode cvenode : cveNodes) {
			String desc = cvenode.getDescription();
			Matcher reservedMatcher = REGEX_RESERVED.matcher(desc);
			Matcher capitalMatcher = REGEX_CAPITAL.matcher(desc);
			if (reservedMatcher.find())
				continue;
			while (capitalMatcher.find()) {
				String res = capitalMatcher.group();
				if (!ret.contains(res))
					ret.add(res);
			}
		}
		String[] retarr = new String[ret.size()];
		retarr = ret.toArray(retarr);
		return retarr;

	}

	private BinarySearchTree<CVEPriorityQueue> buildSearchTree() {
		@SuppressWarnings("rawtypes")
		BinarySearchTree<CVEPriorityQueue> ret = new BinarySearchTree<CVEPriorityQueue>(
				new CVEQueueComparator());
		CVENode[] cveNodes = CVENode.nodeListToArray(myCVEDocument.getNodesByName("item"));
		for (String param : this.getSearchTerms(myCVEDocument)) {
			CVEPriorityQueue<CVENode> queue = new CVEPriorityQueue<CVENode>(
					new CVENodeAlphaComparator(), param);
			for (CVENode cve : cveNodes) {
				if (cve.getName().matches(param))
					queue.append(cve);
				if(queue.size() >= 100){
					break;
				}
			}
			ret.add(queue);
		}

		return ret;
	}

	public CVEPriorityQueue getQueueBySearchTerm(String term) {
		if (term == "" || term == null)
			return null;
		CVEPriorityQueue queue = (CVEPriorityQueue) this.mySearchTree.search(
				new CVEPriorityQueue(new CVEQueueComparator(), term)).getData();
		return queue;
	}
}
