package application;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.*;
import xml.*;

public class CVEModel {
	private BinarySearchTree<PriorityQueue> mySearchTree;
	private CVEDocument myCVEDocument;
	private String mySearchString;

	public CVEModel() {
		myCVEDocument = new CVEDocument("data/cve.xml");
		mySearchString = "";
	}
	public CVEDocument getCVEDocument(){
		return myCVEDocument;
	}
	public String[] getSearchTerms(CVEDocument d){
		ArrayList<String> ret = new ArrayList<String>();
		Pattern captial = Pattern.compile("/([A-Z][\\w-]*(\\s+[A-Z][\\w-]*)+)/");
		
		CVENode[] cveNodes = CVENode.nodeListToArray(d.getNodesByName("item"));
		for(CVENode cvenode : cveNodes){
			String desc = cvenode.getDescription();
			
			Matcher capitalMatcher = captial.matcher(desc);
			while(capitalMatcher.find()){
				String res = capitalMatcher.group();
				if(!ret.contains(res))
					ret.add(res);
			}
		}
		return ret.toArray(new String[ret.size()]);
		
		
	}
	public BinarySearchTree<PriorityQueue> buildSearchTree(){
		BinarySearchTree<PriorityQueue> ret = new BinarySearchTree<PriorityQueue>();
		for(String param : this.getSearchTerms(myCVEDocument)){
			PriorityQueue<CVENode> queue = new PriorityQueue<CVENode>();
			
			
		}
		
		return ret;
	}

}
