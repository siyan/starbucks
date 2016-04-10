package com.sywood.starbucks.ben.SortAlgorithms;

public class BubbleSort {
    static int[] sort(int[] array){
        boolean changed = true;
        while (changed){
            changed = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]){
                    changed = true;
                    int y = array[i+1];
                    array[i+1] = array[i];
                    array[i] = y;
                }
            }
        }
        return array;
    }
}
