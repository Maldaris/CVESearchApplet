package utilities;

import java.util.*;

public class PriorityQueue<T extends Object> {
	private Vector<Object> myData;
	private Comparator<T> myComparator;
	public PriorityQueue(Comparator<T> comparator){
		myData = new Vector<Object>();
		myComparator = comparator;
	}
	public void append(T t){
		myData.addElement(t);
	}
	@SuppressWarnings("unchecked")
	public T remove(){
		if(myData.size() == 0)
			return null;
		return (T) myData.remove(0);
	}
	public int size(){
		return myData.size();
	}
	
}
