/**
 * 
 */
package com.ariv.linkedlist;

import java.util.Iterator;

/**
 * @author al
 *
 */
public class LinkedList<T> implements Iterable<T> {

	/**
	 * 
	 * @author al
	 *
	 * @param <T>
	 */
	static class Node<T> {
		private T data;
		private Node<T> prev, next;

		/**
		 * 
		 */
		public Node() {

		}

		public Node(T data) {
			this.data = data;
		}

		public Node(T data, Node<T> prev, Node<T> next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	/**
	 * Clear the list O(n)
	 */
	public void clear() {
		Node<T> temp = head;
		while (temp != null) {
			Node<T> backup = temp.next;
			temp.next = temp.prev = null;
			temp.data = null;
			temp = backup;
		}
		head = tail = temp = null;
		size = 0;
	}

	/**
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return whether the list has elements
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Add a new element at the tail
	 * 
	 * @param ele
	 */
	public void add(T ele) {
		addLast(ele);
	}

	/**
	 * 
	 * @param ele
	 * 
	 *            Adding an element at the end of the list
	 */
	public void addLast(T ele) {
		if (isEmpty()) {
			head = tail = new Node<>(ele, null, null);
		} else {
			tail.next = new Node<>(ele, tail, null);
			tail = tail.next;
		}
		size++;
	}

	/**
	 * Adding an element at the beginning of the list
	 * 
	 * @param ele
	 */
	public void addFirst(T ele) {
		if (isEmpty()) {
			head = tail = new Node<>(ele, null, null);
		} else {
			head.prev = new Node<>(ele, null, head);
			head = head.prev;
		}
		size++;
	}

	/**
	 * Adding an element at the specified index
	 * 
	 * @param index
	 * @param ele
	 * @throws Exception
	 */
	public void addAt(int index, T ele) throws Exception {
		if (index < 0) {
			throw new Exception("Illegal Index");
		}
		if (index == 0) {
			addFirst(ele);
			return;
		}

		if (index == size) {
			addLast(ele);
			return;
		}
		Node<T> temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}

		Node<T> newNode = new Node<>(ele, temp, temp.next);
		temp.next.prev = newNode;
		temp.next = newNode;
		size++;
	}

	/**
	 * Retrive the first element
	 * 
	 * @return
	 * @throws Exception
	 */
	public T peekFirst() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return head.data;
	}

	/**
	 * Retrive the last element
	 * 
	 * @return
	 * @throws Exception
	 */
	public T peekLast() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return tail.data;
	}

	/**
	 * Remove the first element
	 * 
	 * @return
	 */
	public T removeFirst() {
		if (isEmpty())
			throw new RuntimeException();

		T data = head.data;
		head = head.next;
		size--;

		if (isEmpty()) {
			tail = null;
		} else {
			head.prev = null;
		}

		return data;
	}

	/**
	 * Remove the last element
	 * 
	 * @return
	 */
	public T removeLast() {
		if (isEmpty())
			throw new RuntimeException();

		T data = tail.data;
		tail = tail.prev;
		size--;

		if (isEmpty()) {
			head = null;
		} else {
			tail.next = null;
		}

		return data;
	}

	/**
	 * Remove the arbitrary node.
	 * 
	 * @param node
	 * @return
	 */
	private T remove(Node<T> node) {
		if (node.prev == null) {
			return removeFirst();
		}
		if (node.next == null) {
			return removeLast();
		}

		node.next.prev = node.prev;
		node.prev.next = node.next;

		T data = node.data;
		node.data = null;

		node = node.prev = node.next = null;
		--size;
		return data;
	}

	/**
	 * Remove the element at the specified index.
	 * 
	 * @param index
	 * @return
	 */
	public T removeAt(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}

		int i;
		Node<T> trav;

		if (index < size / 2) {
			for (i = 0, trav = head; i != index; i++) {
				trav = trav.next;
			}
		} else {
			for (i = size - 1, trav = tail; i != index; i--) {
				trav = trav.prev;
			}
		}

		return remove(trav);
	}

	/**
	 * Remove based on the data
	 * 
	 * @param obj
	 * @return
	 */
	public boolean remove(Object obj) {
		Node<T> trav = head;
		if (obj == null) {
			for (trav = head; trav != null; trav = trav.next) {
				if (trav.data == null) {
					remove(trav);
					return true;
				}
			}
		} else {
			for (trav = head; trav != null; trav = trav.next) {
				if (obj.equals(trav.data)) {
					remove(trav);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Retrive the index of the specified data
	 * 
	 * @param obj
	 * @return
	 */
	public int indexOf(Object obj) {
		int index = 0;
		Node<T> trav = head;

		if (obj == null) {
			for (; trav != null; trav = trav.next, index++) {
				if (trav.data == null) {
					return index;
				}
			}
		} else {
			for (; trav != null; trav = trav.next, index++) {
				if (obj.equals(trav.data)) {
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * Verify if the element exist in the list
	 * 
	 * @param obj
	 * @return
	 */
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}

	/**
	 * For the for-each
	 */
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> trav = head;

			@Override
			public boolean hasNext() {
				return trav != null;
			}

			@Override
			public T next() {
				T data = trav.data;
				trav = trav.next;
				return data;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	/**
	 * Display the list
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");

		Node<T> trav = head;

		while (trav != null) {
			sb.append(trav.data);
			if (trav.next != null) {
				sb.append(", ");
			}
			trav = trav.next;
		}
		sb.append(" ]");
		return sb.toString();
	}

}
