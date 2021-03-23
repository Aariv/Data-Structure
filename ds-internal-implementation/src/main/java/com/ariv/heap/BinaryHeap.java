/**
 * 
 */
package com.ariv.heap;

import com.ariv.arrays.DynamicArray;

/**
 * @author Ariv
 *
 */
public class BinaryHeap<T extends Comparable<T>> {

	private DynamicArray<T> heap;

	/**
	 * 
	 */
	public BinaryHeap() {
		this(1);
	}

	public BinaryHeap(int size) {
		heap = new DynamicArray<>(size);
	}

	public BinaryHeap(T[] elems) {
		int heapsize = elems.length;

		heap = new DynamicArray<>(heapsize);

		for (int i = 0; i < heapsize; i++) {
			heap.add(elems[i]);
		}

		// Heapify the process
		for (int i = Math.max(0, (heapsize / 2) - 1); i >= 0; i--) {
			sink(i);
		}
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
	 */
	public void clear() {
		heap.clear();
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return heap.size();
	}

	/**
	 * 
	 * @return
	 */
	public T peek() {
		if (isEmpty()) {
			return null;
		}
		return heap.get(0);
	}

	/**
	 * 
	 * @return
	 */
	public T poll() {
		return removeAt(0);
	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public boolean contains(T elem) {
		for (int i = 0; i < size(); i++) {
			if (heap.get(i).equals(elem)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param elem
	 * @return
	 */
	public boolean remove(T elem) {
		if (elem == null)
			return false;

		for (int i = 0; i < size(); i++) {
			if (elem.equals(heap.get(i))) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param elem
	 */
	public void add(T elem) {
		if (elem == null) {
			throw new IllegalArgumentException();
		}
		heap.add(elem);

		int indexOfLastElem = size() - 1;
		swim(indexOfLastElem);
	}

	/**
	 * @param i
	 * @return
	 */
	private T removeAt(int i) {
		if (isEmpty())
			return null;
		int indexOfLastElem = size() - 1;
		T removedData = heap.get(i);

		swap(i, indexOfLastElem);

		heap.removeAt(indexOfLastElem);

		if (i == indexOfLastElem)
			return removedData;

		T elem = heap.get(i);

		sink(i);

		if (heap.get(i).equals(elem))
			swim(i);
		return removedData;
	}

	/**
	 * Bottom-up approach O(log(n))
	 * 
	 * @param k
	 */
	private void swim(int k) {
		int parent = (k - 1) / 2;

		while (k > 0 && less(k, parent)) {
			swap(parent, k);

			k = parent;

			parent = (k - 1) / 2;
		}
	}

	/**
	 * Top-Down approach O(log(n))
	 * 
	 * @param i
	 */
	private void sink(int k) {
		int heapSize = size();

		while (true) {
			int left = 2 * k + 1;
			int right = 2 * k + 2;

			int smallest = left;

			if (right < heapSize && less(right, left)) {
				smallest = right;
			}

			if (left >= heapSize || less(k, smallest)) {
				break;
			}

			swap(smallest, k);

			k = smallest;
		}
	}

	/**
	 * @param smallest
	 * @param k
	 */
	private void swap(int i, int j) {
		T elemi = heap.get(i);
		T elemj = heap.get(j);

		heap.set(i, elemj);
		heap.set(j, elemi);
	}

	/**
	 * @param right
	 * @param left
	 * @return
	 */
	private boolean less(int i, int j) {
		T node1 = heap.get(i);
		T node2 = heap.get(j);
		return node1.compareTo(node2) <= 0;
	}

}
