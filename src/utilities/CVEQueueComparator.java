package utilities;

import java.util.Comparator;

import xml.CVENode;

public class CVEQueueComparator implements Comparator<CVEPriorityQueue> {

	@Override
	public int compare(CVEPriorityQueue o1,CVEPriorityQueue o2) {
		String s1 = o1.getMySearchTerm();
		String s2 = o2.getMySearchTerm();
		
		return String.CASE_INSENSITIVE_ORDER.compare(s1,s2);
	}

}
