package utilities;

/**
 * Class:    NaturalComparator
 * Purpose:
 * 
 * Date:     Apr 16, 2004
 * @author   dplante
 * @version  1.0
 *
 */
import java.util.Comparator;

public class NaturalComparator implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		return ((Comparable) o1).compareTo(o2);
	}
	
	public boolean equals(Object o)
	{
		boolean flag;
		flag = (o != null) && (o instanceof NaturalComparator);
		return flag;
	}
}
