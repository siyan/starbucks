package com.sywood.starbucks.ben.SortAlgorithms;

public class InsertionSort {
    private static int[] sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                int temp = array[i];
                int j;
                for (j = i-1; j >= 0 && temp < array[j]; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args){
        int[] test = new int[]{3, 2, 1, 9, 7, 4,8};
        test = sort(test);
        for (int num : test){
            System.out.print(num + ", ");
        }
    }
}
