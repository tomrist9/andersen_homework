package org.util;

import java.util.LinkedList;

public class CustomHashSet<T> {
    private LinkedList<T>[] buckets;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    // Constructor
    public CustomHashSet() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    // Hash function to get bucket index
    private int getBucketIndex(T element) {
        return Math.abs(element.hashCode() % buckets.length);
    }

    // Add an element to the set
    public void put(T element) {
        if (contains(element)) {
            return; // Do nothing if element already exists
        }

        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resize(); // Resize when load factor is exceeded
        }

        int index = getBucketIndex(element);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        buckets[index].add(element);
        size++;
    }

    // Check if the set contains an element
    public boolean contains(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index].contains(element);
    }

    // Delete an element from the set
    public void delete(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] != null && buckets[index].remove(element)) {
            size--;
        }
    }

    // Resize the hash table
    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[buckets.length * 2];
        size = 0;

        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T element : bucket) {
                    put(element); // Rehash elements into new buckets
                }
            }
        }
    }

    // Get the current size of the set


    public int getSize() {
        return size;
    }

    // Iterate through all elements
    public void iterate() {
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T element : bucket) {
                    System.out.println(element);
                }
            }
        }
    }

    public int size() {
        return size;
    }
}
