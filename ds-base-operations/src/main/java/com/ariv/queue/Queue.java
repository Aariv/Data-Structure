/**
 * 
 */
package com.ariv.queue;

import com.ariv.operations.BaseOperations;
import com.ariv.operations.BaseQueueOperations;

/**
 * @author al
 *
 */
public class Queue implements BaseOperations, BaseQueueOperations {

	private final int[] arr;

	/**
	 * 
	 */
	public Queue() {
		this(10);
	}

	public Queue(int size) {
		this.arr = new int[size];
	}

	public void enqueue(int val) {
		// TODO Auto-generated method stub

	}

	public void dequeue() {
		// TODO Auto-generated method stub

	}

	public void top() {
		// TODO Auto-generated method stub

	}

	public void display() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
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
