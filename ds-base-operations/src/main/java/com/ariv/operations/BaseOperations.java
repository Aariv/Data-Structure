/**
 * 
 */
package com.ariv.operations;

/**
 * @author al
 *
 */
public interface BaseOperations {

	public void display();

	public void insert(int val);
	
	public void delete(int val);
	
	public void search(int val);
	
	public default void displayForward() {};
	
	public default void displayBackward() {};
}
