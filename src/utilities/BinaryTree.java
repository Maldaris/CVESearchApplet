package utilities;

import java.util.Iterator;

/**
 * Class:  BinaryTree
 * @author Daniel Plante
 * @version 1.0
 */

public class BinaryTree
{
   //////////////////////////////////////////////
   //            Properties                    //
   //////////////////////////////////////////////
   private BinaryTree myLeftTree;
   private BinaryTree myRightTree;
   private BinaryTree myParent;
   private Object myData;

   //////////////////////////////////////////////
   //            Methods                       //
   //////////////////////////////////////////////
   public BinaryTree()
   {
   	  myData = null;
	  myParent = null;
	  myLeftTree = null;
	  myRightTree = null;
   }

   public BinaryTree(Object o)
   {
   	  myData = o;
	  myParent = null;
	  myLeftTree = null;
	  myRightTree = null;
   }

   public BinaryTree(Object datum, BinaryTree left, BinaryTree right)
   {
      this.setParent(null);
      this.setData(datum);
      this.setLeftTree(left);
      this.setRightTree(right);
   }

   public Iterator iterator()
   {
	   BinaryTreeInOrderIterator inIt;

	   inIt = new BinaryTreeInOrderIterator(this);
	   return inIt;
   }
	
   public boolean hasLeftTree()
   {
      BinaryTree leftTree;
      boolean hasOne;
    
      leftTree = this.getLeftTree();
      return leftTree != null;
   }
  
   public boolean hasRightTree()
   {
      BinaryTree rightTree;
      boolean hasOne;
    
      rightTree = this.getRightTree();
      return rightTree != null;
   }

   public boolean isLeafNode()
   {
      boolean flag;
      flag = false;
      if (null == this.getRightTree() &&
          null == this.getLeftTree())
      {
         flag = true;
      }
      return flag;
   }
  
   public void setLeftTree(BinaryTree tree)
   {
      BinaryTree leftTree, leftParent;
    
      leftTree = null;
    
      if(this.hasLeftTree())
      {
         leftTree = this.getLeftTree();
         leftParent = leftTree.getParent();
         if (leftParent == this)
         {
            leftTree.setParent(null);
         }
      }
      
      myLeftTree = tree;
      if(tree != null)
      {
         tree.setParent(this);
      }
   }

   public void setRightTree(BinaryTree tree)
   {
      BinaryTree rightTree, rightParent;
    
      rightTree = null;
    
      if(this.hasRightTree())
      {
         rightTree = this.getRightTree();
         rightParent = rightTree.getParent();
         if (rightParent == this)
         {
            rightTree.setParent(null);
         }
      }
      
      myRightTree = tree;
      if(tree != null)
      {
         tree.setParent(this);
      }
   }

   public BinaryTree getLeftTree()
   {
      return myLeftTree;
   }

   public BinaryTree getRightTree()
   {
      return myRightTree;
   }

   public void setParent(BinaryTree tree)
   {
      myParent = tree;
   }

   public BinaryTree getParent()
   {
      return myParent;
   }

   public void setData(Object data)
   {
      myData = data;
   }

   public Object getData()
   {
      return myData;
   }
}