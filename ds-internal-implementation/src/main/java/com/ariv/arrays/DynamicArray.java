/**
 * 
 */
package com.ariv.arrays;

import java.util.Iterator;

/**
 * @author Ariv
 *
 */
public class DynamicArray<T> implements Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private T[] arr;

	private int len;

	private int capacity;

	/**
	 * 
	 */
	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public DynamicArray(int capacity) {
		if (this.capacity < 0)
			throw new IllegalArgumentException();
		this.capacity = capacity;

		arr = (T[]) new Object[this.capacity];
	}

	/**
	 * 
	 * @return the size of the array
	 */
	public int size() {
		return len;
	}

	/**
	 * 
	 * @return whether array is empty or not
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 
	 * @param index
	 * @return the element available at the index
	 */
	public T get(int index) {
		ensureCapacity(index);
		return arr[index];
	}

	/**
	 * 
	 * @param index index of the element
	 * @param ele   element to be updated in the given index
	 */
	public void set(int index, T ele) {
		ensureCapacity(index);
		arr[index] = ele;
	}

	/**
	 * Clear all the elements in the array
	 */
	public void clear() {
		for (int i = 0; i < len; i++) {
			arr[i] = null;
		}
		len = 0;
	}

	/**
	 * 
	 * @param ele element to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(T ele) {
		if (len + 1 >= capacity) {
			if (capacity == 0) {
				capacity = 1;
			} else {
				capacity *= 2;
			}

			T[] newArr = (T[]) new Object[capacity];

			for (int i = 0; i < len; i++) {
				newArr[i] = arr[i];
			}

			arr = newArr;
		}
		arr[len++] = ele;
	}

	/**
	 * 
	 * @param index of the element to be removed
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T removeAt(int index) {
		ensureCapacity(index);
		T data = arr[index];

		T[] newArr = (T[]) new Object[len - 1];

		for (int i = 0, j = 0; i < len; i++, j++) {
			if (i == index)
				j--;
			else
				newArr[j] = arr[i];
		}
		arr = newArr;
		capacity = --len;
		return data;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index == -1)
			return false;
		removeAt(index);
		return true;
	}

	/**
	 * @param obj
	 * @return
	 */
	private int indexOf(Object obj) {
		for (int i = 0; i < len; i++) {
			if (obj == null) {
				if (arr[i] == null) {
					return i;
				}
			} else {
				if (obj.equals(arr[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	/**
	 * 
	 */
	public String toString() {
		if (len == 0)
			return "[]";
		else {
			StringBuilder sb = new StringBuilder().append("[");
			for (int i = 0; i < len - 1; i++) {
				sb.append(arr[i] + ", ");
			}
			return sb.append(arr[len - 1] + "]").toString();
		}
	}

	/**
	 * 
	 * @param index
	 */
	private void ensureCapacity(int index) {
		if (index >= len || index < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	public Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index = 0;

			public boolean hasNext() {
				return index < len;
			}

			public T next() {
				return arr[index++];
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
