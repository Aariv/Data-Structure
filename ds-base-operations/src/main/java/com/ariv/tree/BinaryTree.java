/**
 * 
 */
package com.ariv.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ariv.operations.BaseOperations;
import com.ariv.operations.BaseTreeOperations;

/**
 * @author al
 *
 */
public class BinaryTree implements BaseOperations, BaseTreeOperations {

	static class BTreeNode {
		int data;
		BTreeNode left;
		BTreeNode right;

		/**
		 * 
		 */
		public BTreeNode() {
		}

		public BTreeNode(int data) {
			this.data = data;
		}
	}

	BTreeNode root;

	@Override
	public void preorder() {
		preorder(root);
	}

	/**
	 * @param root
	 */
	private void preorder(BTreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	@Override
	public void inorder() {
		inorder(root);
	}

	/**
	 * @param root
	 */
	private void inorder(BTreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	@Override
	public void postorder() {
		postorder(root);
	}

	/**
	 * @param root
	 */
	private void postorder(BTreeNode root) {
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	@Override
	public void levelorder() {
		Queue<BTreeNode> queue = new LinkedList<BinaryTree.BTreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) 
		{
			BTreeNode curr = queue.poll();
			
			System.out.print( curr.data + " ");
			
			if(curr.left != null) 
				queue.add(curr.left);
			
			
			if(curr.right != null)
				queue.add(curr.right);
		}
		System.out.println();
	}

	@Override
	public void display() {
		preorder();
	}

	@Override
	public void insert(int val) {

	}

	@Override
	public void delete(int val) {

	}

	@Override
	public void search(int val) {

	}

	@Override
	public void preorderIterative() {
		Stack<BTreeNode> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			BTreeNode top = stack.pop();
			System.out.print(top.data + " ");
			if (top.right != null)
				stack.push(top.right);

			if (top.left != null)
				stack.push(top.left);
		}
	}

	@Override
	public void inorderIterative() {
		Stack<BTreeNode> stack = new Stack<>();
		BTreeNode curr = root;
		while (true) {

			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			if (stack.isEmpty())
				break;
			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	@Override
	public void postorderIterative() {
		Stack<BTreeNode> stack1 = new Stack<>();
		Stack<BTreeNode> reverse = new Stack<>();

		stack1.push(root);

		while (stack1.isEmpty()) {

			BTreeNode node = stack1.pop();
			reverse.push(node);

			if (node.left != null) {
				stack1.push(node.left);
			}

			if (node.right != null)
				stack1.push(node.right);
		}

		while (!reverse.isEmpty()) {
			System.out.print(reverse.pop().data + " ");
		}
		System.out.println();
	}

}
