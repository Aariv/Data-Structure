/**
 * 
 */
package com.ariv.linkedlist;

import com.ariv.operations.BaseOperations;

/**
 * @author al
 *
 */
public class DoublyList implements BaseOperations {

	static class DNode {
		int data;

		DNode prev;
		DNode next;
	}

	DNode head;
	DNode tail;

	public void display() {
		DNode curr = head;

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	public void insert(int val) {

	}

	public void delete(int val) {

	}

	public void search(int val) {

	}

	@Override
	public void displayForward() {
		display();
	}

	@Override
	public void displayBackward() {
		DNode curr = tail;

		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.prev;
		}
		System.out.println();
	}
}
