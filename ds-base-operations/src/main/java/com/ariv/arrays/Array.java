/**
 * 
 */
package com.ariv.arrays;

import com.ariv.operations.BaseOperations;

/**
 * @author al
 *
 */
public class Array implements BaseOperations {

	private final int[] arr;

	/**
	 * 
	 */
	public Array() {
		this(5);
	}

	public Array(int size) {
		arr = new int[size];
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
