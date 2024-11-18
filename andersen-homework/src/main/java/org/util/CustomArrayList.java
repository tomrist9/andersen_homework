package org.util;

import java.util.ArrayList;
import java.util.Arrays;

public class TestArrayList <T>{
    private Object[] items;
    int size=0;
    public TestArrayList() {
        items = new Object[10];
    }

    public void put(T item) {
        if(size==items.length){
            resize();

        }
        items[size++]=item;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) items[index];
    }
    public int delete(int index) {
        if (index == 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--size] = null;
    }
    private void resize(){
        items= Arrays.copyOf(items, items.length*2);
    }

}
