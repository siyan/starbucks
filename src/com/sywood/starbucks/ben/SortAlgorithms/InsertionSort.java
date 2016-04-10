package com.sywood.starbucks.ben.SortAlgorithms;

public class InsertionSort {
    static int[] sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
                for (int j = i-1; j > 0; j--) {
                    if (array[j] < array[j-1]){
                        int x = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
            }
        }
        return array;
    }
}
