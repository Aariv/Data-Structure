/**
 * 
 */
package com.ariv.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import com.ariv.linkedlist.LinkedList;
import java.util.List;

class Entry<K, V> {
	int hash;
	K key;
	V value;

	/**
	 * 
	 */
	public Entry() {

	}

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}

	public boolean equals(Entry<K, V> other) {
		if (hash != other.hash) {
			return false;
		}
		return key.equals(other);
	}
}

public class HashTableSeperateChaining<K, V> implements Iterable<K> {

	private static final int DEFAULT_CAPACITY = 3;
	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	private double maxLoadFactor;

	private int capacity, threshold, size = 0;

	private LinkedList<Entry<K, V>>[] table;

	/**
	 * 
	 */
	public HashTableSeperateChaining() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	public HashTableSeperateChaining(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * @param capacity
	 * @param maxLoadFactor
	 */
	@SuppressWarnings("unchecked")
	public HashTableSeperateChaining(int capacity, double maxLoadFactor) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}

		if (maxLoadFactor < 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite(maxLoadFactor)) {
			throw new IllegalArgumentException();
		}
		this.maxLoadFactor = maxLoadFactor;
		this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
		threshold = (int) (this.capacity * maxLoadFactor);

		table = new LinkedList[this.capacity];
	}

	public Iterator<K> iterator() {
		return null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void clear() {
		Arrays.fill(table, null);
		size = 0;
	}

	public boolean hasKey(K key) {
		int bucketIndex = normalizeIndex(key.hashCode());
		return bucketSeekEntry(bucketIndex, key) != null;
	}

	public V put(K key, V value) {
		return insert(key, value);
	}

	public V add(K key, V value) {
		return insert(key, value);
	}

	/**
	 * @param key
	 * @param value
	 * @return
	 */
	private V insert(K key, V value) {
		if (key == null)
			throw new IllegalArgumentException();
		Entry<K, V> newEntry = new Entry<>(key, value);
		int bucketIndex = normalizeIndex(newEntry.hash);
		return bucketInsertEntry(bucketIndex, newEntry);
	}

	/**
	 * @param bucketIndex
	 * @param newEntry
	 * @return
	 */
	private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry) {
		LinkedList<Entry<K, V>> bucket = table[bucketIndex];
		if (bucket == null)
			table[bucketIndex] = bucket = new LinkedList<>();

		Entry<K, V> existEntry = bucketSeekEntry(bucketIndex, entry.key);
		if (existEntry == null) {
			bucket.add(entry);
			if (++size > threshold) {
				resizeTable();
			}
			return null;
		} else {
			V oldValue = existEntry.value;
			existEntry.value = entry.value;
			return oldValue;
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		if (key == null)
			return null;

		int bucketIndex = normalizeIndex(key.hashCode());

		Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);

		if (entry != null)
			return entry.value;

		return null;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		if (key == null)
			return null;

		int bucketIndex = normalizeIndex(key.hashCode());

		return bucketRemoveEntry(bucketIndex, key);
	}

	/**
	 * 
	 * @return
	 */
	public List<K> keys() {
		List<K> keys = new ArrayList<>();

		for (LinkedList<Entry<K, V>> bucket : table) {
			if (bucket != null) {
				for (Entry<K, V> entry : bucket) {
					keys.add(entry.key);
				}
			}
		}
		return keys;
	}

	/**
	 * 
	 * @return
	 */
	public List<V> values() {
		List<V> values = new ArrayList<>();

		for (LinkedList<Entry<K, V>> bucket : table) {
			if (bucket != null) {
				for (Entry<K, V> entry : bucket) {
					values.add(entry.value);
				}
			}
		}
		return values;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");

		for (int i = 0; i < capacity; i++) {
			if (table[i] == null)
				continue;
			for (Entry<K, V> entry : table[i]) {
				sb.append(entry + ", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * @param bucketIndex
	 * @param key
	 * @return
	 */
	private V bucketRemoveEntry(int bucketIndex, K key) {
		Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
		if (entry != null) {
			LinkedList<Entry<K, V>> links = table[bucketIndex];
			links.remove(entry);
			--size;
			return entry.value;
		}
		return null;
	}

	/**
	 * 
	 */
	private void resizeTable() {
		capacity *= 2;
		threshold = (int) (capacity * maxLoadFactor);

		@SuppressWarnings("unchecked")
		LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				for (Entry<K, V> entry : table[i]) {
					int bucketIndex = normalizeIndex(entry.hash);
					LinkedList<Entry<K, V>> bucket = newTable[bucketIndex];
					if (bucket == null) {
						newTable[bucketIndex] = bucket = new LinkedList<>();
					}
					bucket.add(entry);
				}

				// Avoid memory leak
				table[i].clear();
				table[i] = null;
			}
		}

		table = newTable;
	}

	/**
	 * @param bucketIndex
	 * @param key
	 * @return
	 */
	private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {
		if (key == null)
			return null;

		LinkedList<Entry<K, V>> bucket = table[bucketIndex];
		if (bucket == null)
			return null;

		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				return entry;
			}
		}
		return null;
	}

	/**
	 * @param hashCode
	 * @return
	 */
	private int normalizeIndex(int keyHash) {
		return (keyHash & 0x7FFFFFFF % capacity);
	}
}
