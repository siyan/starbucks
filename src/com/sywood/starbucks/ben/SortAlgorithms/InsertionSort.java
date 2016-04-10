package com.sywood.starbucks.ben.SortAlgorithms;

public class InsertionSort {
    static int[] sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                for (int j = i; j > 0; j--) {
                    if (array[j] < array[j-1]){
                        int temp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = temp;
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] test = new int[]{2, 3, 1, 7};
        test = sort(test);
        for (int num : test){
            System.out.print(num + ", ");
        }
    }
}
