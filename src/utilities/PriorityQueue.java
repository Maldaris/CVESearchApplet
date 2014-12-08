package utilities;

import java.util.*;

public class PriorityQueue<T extends Object> {
	private Vector<Object> myData;
	
	public PriorityQueue(){
		myData = new Vector<Object>();
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
