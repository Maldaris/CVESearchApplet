package utilities;

/**
 * Class:    BinarySearchTree
 * Purpose:
 * 
 * Date:     Apr 16, 2004
 * @author   dplante
 * @version  1.0
 *
 */
import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree extends BinaryTree
{
	//////////////////////////////////////////////
	//            Properties                    //
	//////////////////////////////////////////////
    private Comparator myComparator;
    
	//////////////////////////////////////////////
	//            Methods                       //
	//////////////////////////////////////////////
	public BinarySearchTree()
	{
		super();
		myComparator = new NaturalComparator();
	}
	
	public BinarySearchTree(Object datum)
	{
		super(datum);
		myComparator = new NaturalComparator();
	}
  
	public BinarySearchTree(Object datum, BinarySearchTree left, 
                                          BinarySearchTree right)
	{
		super(datum, left, right);
		myComparator = new NaturalComparator();
	}
	
	public void add(Object o)
	{
		this.insert(o, this);
	}
	
	public void remove(Object o)
	{
		this.delete(o, this);
	}
	
	public boolean contains(Object o)
	{
		return true;
	}
	
	public void insert(Object o)
	{
		this.insert(o, this);
	}
	
	private void insert(Object o, BinarySearchTree root)
	{
	    BinarySearchTree node;
	    Object rootData;
	    int check;
	    
	    if(root == null)
	    {
	        return;
	    }
	    
	    rootData = root.getData();
	    check = 0;
	    node = null;
	    
	    if(rootData == null)
	    {
	        this.setData(o);
	    }
	    else
	    {
	        check = myComparator.compare(o, rootData);
	        if(check < 0)
	        {
	            node = (BinarySearchTree) root.getLeftTree();
	            if (node == null)
	            {
	                node = new BinarySearchTree(o);
	                node.setParent(root);
	                root.setLeftTree(node);
	                return;
	            }
	            this.insert(o, node);
	        }
	        else
	        {
	            node = (BinarySearchTree) root.getRightTree();
	            if(node == null)
	            {
	                node = new BinarySearchTree(o);
	                node.setParent(root);
	                root.setRightTree(node);
	                return;
	            }
	            this.insert(o, node);
	        }
	    }
	}
	
	public void delete(Object o)
	{
		this.delete(o, this);
	}
	
	private void delete(Object o, BinarySearchTree root)
	{
		
	}
	
	public BinarySearchTree search(Object o)
	{
		return search(o, this);
	}
	
	private BinarySearchTree search(Object o, BinarySearchTree root)
	{
		// Dummy search tree just to make code compile!
		return new BinarySearchTree();
	}
}
