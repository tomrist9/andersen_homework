package org.util;

import java.util.LinkedList;

public class CustomHashSet<T> {
    private LinkedList<T>[] buckets;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    
    public CustomHashSet() {

        this.buckets = new LinkedList[DEFAULT_CAPACITY];
    }

    
    private int getBucketIndex(T element) {
        return Math.abs(element.hashCode() % buckets.length);
    }

    
    public void put(T element) {
        if (contains(element)) {
            return; 
        }

        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resize(); 
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

    
    public void delete(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] != null && buckets[index].remove(element)) {
            size--;
        }
    }


    private void resize() {
        LinkedList<T>[] oldBuckets = buckets;
        buckets = new LinkedList[buckets.length * 2];
        size = 0;

        for (LinkedList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (T element : bucket) {
                    put(element); 
                }
            }
        }
    }

    


    public int getSize() {
        return size;
    }

    
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
