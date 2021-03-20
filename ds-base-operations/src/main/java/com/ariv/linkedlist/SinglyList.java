/**
 * 
 */
package com.ariv.linkedlist;

import com.ariv.operations.BaseOperations;

/**
 * @author al
 *
 */
public class SinglyList implements BaseOperations {

	static class SNode {
		int data;

		SNode next;
	}

	SNode head;

	public void display() {
		SNode curr = head;

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public void insert(int val) {
		// TODO Auto-generated method stub

	}

	public void delete(int val) {
		// TODO Auto-generated method stub

	}

	public void search(int val) {
		// TODO Auto-generated method stub

	}

}
