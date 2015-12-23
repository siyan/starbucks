package com.sywood.starbucks.siyan.ccc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by siyan on 15-12-22.
 */
public class OnJavaObject {


    public OnJavaObject() {
    }

    private void compareObj() {
        Integer int1 = Integer.parseInt( "2" );
        Integer int2 = Integer.parseInt( "2" );

        System.out.println( " integer equal ? " + (int1 == int2));

        int[] arr1 = { 1, 2 };
        int[] arr2 = { 1, 2 };

        System.out.println( " array equal ? " + (arr1 == arr2));
    }

    private void listContain() {
        Integer int1 = Integer.parseInt( "2" );
        Integer int2 = Integer.parseInt( "2" );
        List list1 = new LinkedList();
        list1.add( int2 );
        System.out.println( "contains integer ? " + list1.contains( int2 ));


        int[] arr1 = { 1, 2 };
        int[] arr2 = { 1, 2 };
        List list2 = new LinkedList();
        System.out.println( "contains array ? " + list2.contains( arr2 ));

    }

    public static void main( String[] args ) {

        OnJavaObject ojo = new OnJavaObject();
        ojo.compareObj();
        ojo.listContain();
    }
}
