package application;

import java.util.ArrayList;

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
	public String[] getSearchTerms(CVEDocument d){
		
		CVENode[] cveNodes = CVENode.nodeListToArray(d.getNodesByName("item"));
		for(CVENode cvenode : cveNodes){
			String desc = cvenode.getDescription();
		}
	}
	public BinarySearchTree<PriorityQueue> buildSearchTree(){
		BinarySearchTree<PriorityQueue> ret = new BinarySearchTree<PriorityQueue>();
		
		
		
		
		return ret;
	}

}
