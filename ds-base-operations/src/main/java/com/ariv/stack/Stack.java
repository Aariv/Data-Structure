/**
 * 
 */
package com.ariv.stack;

import com.ariv.operations.BaseOperations;
import com.ariv.operations.BaseStackOperations;

/**
 * @author al
 *
 */
public class Stack implements BaseOperations, BaseStackOperations {

	private final int[] arr;

	/**
	 * 
	 */
	public Stack() {
		this(10);
	}

	public Stack(int size) {
		this.arr = new int[size];
	}

	public void display() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void insert(int val) {

	}

	public void delete(int val) {

	}

	public void search(int val) {

	}

	public void push(int val) {

	}

	public void pop() {

	}

	public void top() {

	}

}
