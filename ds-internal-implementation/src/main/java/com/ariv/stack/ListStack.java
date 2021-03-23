/**
 * 
 */
package com.ariv.stack;

import java.util.EmptyStackException;
import java.util.Iterator;

import com.ariv.linkedlist.LinkedList;

/**
 * @author Ariv
 *
 */
public class ListStack<T> implements Iterable<T> {

	LinkedList<T> list = new LinkedList<>();

	/**
	 * 
	 */
	public ListStack() {
	}

	public ListStack(T ele) {
		push(ele);
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return list.size();
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * @param ele
	 */
	public void push(T ele) {
		list.addLast(ele);
	}

	/**
	 * 
	 * @return
	 */
	public T pop() {
		if (isEmpty())
			throw new EmptyStackException();

		return list.removeLast();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public T peek() throws Exception {
		if (isEmpty())
			throw new EmptyStackException();

		return list.peekLast();
	}
	
	/**
	 * 
	 * @param ele
	 * @return
	 */
	public int search(T ele) {
		return list.indexOf(ele);
	}

	/**
	 * 
	 */
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

}
