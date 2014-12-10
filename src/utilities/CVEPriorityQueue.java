package utilities;

import java.util.Comparator;

import xml.CVENode;

public class CVEPriorityQueue<T extends CVENode> extends PriorityQueue<T> 
{
	private String mySearchTerm;

	public String getMySearchTerm() {
		return mySearchTerm;
	}

	public void setMySearchTerm(String mySearchTerm) {
		this.mySearchTerm = mySearchTerm;
	}

	public CVEPriorityQueue(Comparator<T> comparator, String searchTerm) {
		super(comparator);
		mySearchTerm = searchTerm;
	}


	

}
