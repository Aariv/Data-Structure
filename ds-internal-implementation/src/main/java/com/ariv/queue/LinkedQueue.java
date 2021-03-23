/**
 * 
 */
package com.ariv.queue;

import java.util.Iterator;

import com.ariv.linkedlist.LinkedList;

/**
 * @author Ariv
 *
 */
public class LinkedQueue<T> implements Iterable<T> {

	private LinkedList<T> list = new LinkedList<>();

	/**
	 * 
	 */
	public LinkedQueue() {
		// TODO Auto-generated constructor stub
	}

	public LinkedQueue(T ele) {
		offer(ele);
	}

	/**
	 * 
	 * @return the number of elememts in the queue.
	 */
	public int size() {
		return list.size();
	}

	/**
	 * 
	 * @return true when the queue has no elements
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * 
	 * @return the first element of the queue
	 * @throws Exception
	 */
	public T peek() throws Exception {
		if (isEmpty()) {
			throw new RuntimeException();
		}
		return list.peekFirst();
	}

	/**
	 * 
	 * @return the first element of the queue and delete from queue.
	 */
	public T poll() {
		if (isEmpty())
			throw new RuntimeException();
		return list.removeFirst();
	}

	/**
	 * add new element at the end of the queue.
	 * @param ele
	 */
	public void offer(T ele) {
		list.addLast(ele);
	}

	/**
	 * 
	 */
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
