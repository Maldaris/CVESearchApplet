package utilities;

import java.util.*;

public class PriorityQueue<T extends Object> {
	private Vector<Object> myData;
	private Comparator<T> myComparator;
	public PriorityQueue(Comparator<T> comparator){
		myData = new Vector<Object>();
		myComparator = comparator;
	}
	@SuppressWarnings("unchecked")
	public void append(T t){
		for(int x = 0; x < myData.size(); x++){
			int res = myComparator.compare(t, (T) myData.get(x));
			if(res <= 0){
				myData.insertElementAt(t, x);
			}
		}
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
