/**
 * 
 */
package com.ariv.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Ariv
 *
 */
public class ArrayStack<T> {

	private int size;
	private int capacity;
	private Object[] arr;

	/**
	 * 
	 */
	public ArrayStack() {
		this(5);
	}

	/**
	 * @param i
	 */
	public ArrayStack(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		this.arr = new Object[capacity];
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 
	 * @param ele
	 */
	public void push(T ele) {
		if (size == capacity) {
			increaseCapacity();
		}
		arr[size++] = ele;
	}

	/**
	 * 
	 * @return
	 */
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		T elem = (T) arr[size--];
		arr[size] = null;
		return elem;
	}

	/**
	 * 
	 * @return
	 */
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();

		T elem = (T) arr[size - 1];
		return elem;
	}

	/**
	 * 
	 */
	private void increaseCapacity() {
		capacity *= 2;
		arr = Arrays.copyOf(arr, capacity);
	}
}
