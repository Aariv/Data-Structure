/**
 * 
 */
package com.ariv.arrays;

/**
 * @author Ariv
 *
 */
public class DynamicArrayTest {

	public static void main(String[] args) {

		DynamicArray<Integer> intArray = new DynamicArray<Integer>(3);

		DynamicArray<String> stringArray = new DynamicArray<String>(5);

		DynamicArray<Byte> byteArray = new DynamicArray<Byte>(5);

		intArray.add(10);

		intArray.add(34);

		intArray.add(23);

		intArray.add(6);

		intArray.add(45);

		intArray.add(434);

		for (Integer intValue : intArray) {
			System.out.print(intValue + " ");
		}
		System.out.println();

		for (int i = 0; i < intArray.size(); i++) {
			System.out.print(intArray.get(i) + " ");
		}
		System.out.println();

		System.out.println(intArray.toString());

		intArray.remove(23);

		System.out.println(intArray.toString());

		System.out.println(intArray.contains(434));
		System.out.println(intArray.contains(435));
		
		
		/**
		 * String Array
		 */
		stringArray.add("A");
		
		stringArray.add("B");
		
		stringArray.add("C");
		
		stringArray.add("D");
		
		stringArray.add("E");
		
		System.out.println(stringArray.toString());
	}
}
