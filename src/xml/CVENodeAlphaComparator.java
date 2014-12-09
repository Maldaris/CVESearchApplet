package xml;

import java.util.Comparator;

public class CVENodeAlphaComparator implements Comparator<CVENode> {

	@Override
	public int compare(CVENode o1, CVENode o2) {
		String s1 = o1.getName();
		String s2 = o2.getName();
		
		return String.CASE_INSENSITIVE_ORDER.compare(s1,s2);
	}
	public boolean equals(CVENode o1, CVENode o2){
		return o1.equals(o2);
	}

}
