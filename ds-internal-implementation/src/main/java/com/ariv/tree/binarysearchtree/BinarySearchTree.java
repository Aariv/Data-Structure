/**
 * 
 */
package com.ariv.tree.binarysearchtree;

/**
 * @author al
 *
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private int nodeCount = 0;

	private TreeNode<T> root;

	private class TreeNode<T> {
		T data;
		TreeNode<T> left, right;

		/**
		 * 
		 */
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}

		public TreeNode(T data) {
			this.data = data;
		}

		public TreeNode(T data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return nodeCount;
	}

	public boolean add(T elem) {
		if (contains(elem)) {
			return false;
		} else {
			root = add(root, elem);
			nodeCount++;
			return true;
		}
	}

	/**
	 * @param node
	 * @param ele
	 * @return
	 */
	private TreeNode<T> add(TreeNode<T> node, T elem) {
		if (node == null)
			node = new TreeNode<T>(elem);
		else {
			if (elem.compareTo(node.data) < 0) {
				node.left = add(node.left, elem);
			} else {
				node.right = add(node.right, elem);
			}
		}
		return node;
	}

	public boolean remove(T elem) {
		if (contains(elem)) {
			root = remove(root, elem);
			nodeCount--;
			return true;
		}
		return false;
	}

	/**
	 * @param node
	 * @param elem
	 * @return
	 */
	private TreeNode<T> remove(TreeNode<T> node, T elem) {
		if (node == null)
			return null;
		int cmp = elem.compareTo(node.data);
		if (cmp < 0) {
			node.left = remove(node.left, elem);
		} else if (cmp > 0) {
			node.right = remove(node.right, elem);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				TreeNode<T> tmp = findMin(node.right);
				node.data = tmp.data;
				node.right = remove(node.right, tmp.data);
			}
		}
		return node;
	}

	/**
	 * @param right
	 * @return
	 */
	private TreeNode<T> findMin(TreeNode<T> right) {
		while (right.left != null) {
			right = right.left;
		}
		return right;
	}

	/**
	 * @param ele
	 * @return
	 */
	private boolean contains(T ele) {
		// TODO Auto-generated method stub
		return false;
	}
}
