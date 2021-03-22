/**
 * 
 */
package com.ariv.hashtable;

import java.util.LinkedList;

/**
 * @author al
 *
 */
public class HashTableTest {

	public static void main(String[] args) {
		HashTableSeperateChaining<String, String> domainMap = new HashTableSeperateChaining<>();
		
		domainMap.put("google.com", "192.45.523.23");
		
		domainMap.put("yahoo.com", "192.45.523.23");
		
		domainMap.put("facebook.com", "192.45.523.23");
		
		domainMap.put("tpd.com", "192.45.523.23");
		
		domainMap.put("vererrg.com", "192.45.523.23");
		
		for(String entry: domainMap) {
			System.out.println(entry);
		}
		
		LinkedList<Integer> list = new LinkedList<>();
	}
}
