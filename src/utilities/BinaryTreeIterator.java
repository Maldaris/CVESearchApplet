package utilities;

/**
 * Class:  BinaryTreeIterator
 * @author Daniel Plante
 * @version 1.0
 */
import java.util.Iterator;
import java.util.Vector;

public abstract class BinaryTreeIterator implements Iterator
{
	//////////////////////////////////////////////
	//            Properties                    //
	//////////////////////////////////////////////
    private Vector myTreeVector;
    private int myIndex;
    private int mySize;
    
	//////////////////////////////////////////////
	//            Methods                       //
	//////////////////////////////////////////////
	public BinaryTreeIterator(BinaryTree tree)
	{
		myTreeVector = new Vector();
		this.buildTreeVector(tree);
		myTreeVector.trimToSize();
		myIndex = 0;
		mySize = myTreeVector.size();
	}
	
	//////////////////////
	//  Abstract method //
	//////////////////////
	public abstract void buildTreeVector(BinaryTree tree);
	
	public boolean hasNext()
	{
		return myIndex < mySize;
	}
	
	public Object next()
	{
		Object o;
		
		o = myTreeVector.elementAt(myIndex);
		myIndex++;
		return o;
	}
	
	protected void setTreeVector(Vector vector)
	{
		myTreeVector = vector;
	}
	
	public Vector getTreeVector()
	{
		return myTreeVector;
	}
	
	public void remove()
	{
		// Do nothing, but must override.  To implement, same as
		// delete() in BinarySearchTree.
	}
}
