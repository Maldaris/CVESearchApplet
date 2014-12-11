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

public class BinarySearchTree<T extends Object> extends BinaryTree {
	// ////////////////////////////////////////////
	// Properties //
	// ////////////////////////////////////////////
	private Comparator<T> myComparator;

	// ////////////////////////////////////////////
	// Constructors //
	// ////////////////////////////////////////////
	public BinarySearchTree() {
		super();
		myComparator = new NaturalComparator<T>();
	}
	public BinarySearchTree(Comparator<T> t) {
		super();
		myComparator = t;
	}
	public BinarySearchTree(Comparator<T> t, Object datum) {
		super(datum);
		myComparator = t;
	}

	public BinarySearchTree(Comparator<T> t, Object datum,
			BinarySearchTree<?> left, BinarySearchTree<?> right) {
		super(datum, left, right);
		myComparator = t;
	}

	// ////////////////////////////////////////////
	// Methods //
	// ////////////////////////////////////////////

	public void add(Object o) {
		this.insert(o, this);
	}

	public void remove(Object o) {
		this.delete(o, this);
	}

	public boolean contains(Object o) {
		if (search(o, this) != null) {
			return true;
		}
		return false;
	}

	public void insert(Object o) {
		this.insert(o, this);
	}

	@SuppressWarnings("unchecked")
	private void insert(Object o, BinarySearchTree<?> root) {
		BinarySearchTree<T> node;
		Object rootData;
		int check;

		if (root == null) {
			return;
		}

		rootData = root.getData();
		check = 0;
		node = null;

		if (rootData == null) {
			this.setData(o);
		} else {
			check = myComparator.compare((T) o, (T) rootData);
			if (check < 0) {
				node = (BinarySearchTree<T>) root.getLeftTree();
				if (node == null) {
					node = new BinarySearchTree<T>(myComparator, o);
					node.setParent(root);
					root.setLeftTree(node);
					return;
				}
				this.insert(o, node);
			} else {
				node = (BinarySearchTree<T>) root.getRightTree();
				if (node == null) {
					node = new BinarySearchTree<T>(myComparator, o);
					node.setParent(root);
					root.setRightTree(node);
					return;
				}
				this.insert(o, node);
			}
		}
	}

	public void delete(Object o) {
		this.delete(o, this);
	}

	// EDIT
	@SuppressWarnings("unchecked")
	private void delete(Object o, BinarySearchTree<?> root) {
		// NEED TO USE ROOT SOMEWHERE

		BinarySearchTree<T> node;
		BinarySearchTree<T> nodeParent;
		BinarySearchTree<T> nodeLeftChild;
		BinarySearchTree<T> nodeRightChild;
		int check;

		check = 0;
		node = null;

		// Make sure the object to be deleted does NOT equal null
		// Cannot delete a null object
		if (o != null) {
			node = this.search(o);

			// Check for 0 children
			if (node.hasLeftTree() == false && node.hasRightTree() == false) {
				if (node.getParent() != null) {
					nodeParent = (BinarySearchTree<T>) node.getParent();
					nodeParent.setLeftTree(null);
					nodeParent.setRightTree(null);
				} else {
					return;
				}
			}

			// Check for children
			else if (node.hasLeftTree() == true || node.hasRightTree() == true) {
				// Check for 1 left child
				if (node.hasLeftTree() == true && node.hasRightTree() == false) {
					if (node.getParent() != null) {
						nodeParent = (BinarySearchTree<T>) node.getParent();
						nodeLeftChild = (BinarySearchTree<T>) node
								.getLeftTree();
						nodeLeftChild.setParent(nodeParent);
					} else {
						return;
					}
				}

				// Check for 1 right child
				else if (node.hasLeftTree() == false
						&& node.hasRightTree() == true) {
					if (node.getParent() != null) {
						nodeParent = (BinarySearchTree<T>) node.getParent();
						nodeRightChild = (BinarySearchTree<T>) node
								.getRightTree();
						nodeRightChild.setParent(nodeParent);
					} else {
						return;
					}
				}

				// Check for 2 children
				else if (node.hasLeftTree() == true
						&& node.hasRightTree() == true) {
					if (node.getParent() != null) {
						nodeParent = (BinarySearchTree<T>) node.getParent();
						nodeLeftChild = (BinarySearchTree<T>) node
								.getLeftTree();
						nodeRightChild = (BinarySearchTree<T>) node
								.getRightTree();

						BinarySearchTree<T> nodeLeftOfRightChild;

						if (nodeRightChild.getLeftTree() != null) {
							nodeLeftOfRightChild = (BinarySearchTree<T>) nodeRightChild
									.getLeftTree();

							while (nodeLeftOfRightChild.getLeftTree() != null) {
								nodeLeftOfRightChild = (BinarySearchTree<T>) nodeLeftOfRightChild
										.getLeftTree();
							}

							nodeRightChild.setParent(nodeLeftOfRightChild);
							nodeLeftChild.setParent(nodeLeftOfRightChild);
							nodeLeftOfRightChild.setParent(nodeParent);
						} else
							nodeLeftChild.setParent(nodeRightChild);
						nodeRightChild.setParent(nodeParent);

					} else {
						return;
					}
				}
			}
		}
	}

	public BinarySearchTree<T> search(Object o) {
		return search(o, this);
	}

	// Generic issue here
	@SuppressWarnings("unchecked")
	private BinarySearchTree<T> search(Object o, BinarySearchTree<T> root) {
		for (Iterator iterator = root.iterator(); iterator.hasNext();) {
			BinarySearchTree<T> t = (BinarySearchTree<T>) iterator.next();
			if (t.getData().equals(o))
				return t;
		}
		return null;
	}
}
