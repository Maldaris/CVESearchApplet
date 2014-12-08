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

public class NaturalComparator<T extends Object> implements Comparator<T>
{

	/*
	 * Once again, note that the comparator casting is valid regardless of warnings
	 * due to type restrictions in the class declaration in not one but TWO parent
	 * classes for this application. 
	 * (I really should write a utility class to circumvent this annoying warning, 
	 *  and the need for annotations to suppress it.) 
	 */
	
	public int compare(Object o1, Object o2)
	{
		return ((Comparable<T>) o1).compareTo((T) o2);
	}
	
	public boolean equals(Object o)
	{
		boolean flag;
		flag = (o != null) && (o instanceof NaturalComparator);
		return flag;
	}
}
