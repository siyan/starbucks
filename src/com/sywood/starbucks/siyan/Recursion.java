package com.sywood.starbucks.siyan;

/**
 * Created by siyan on 8/23/15.
 */
public class Recursion {
    int stringCount( String str, String subStr ) {

        int subLen = subStr.length();

        if( str == null || str.length() == 0 || subStr == null) {
            return 0;
        }
        else if ( subStr.equalsIgnoreCase( str.substring( 0, subLen) )) {
            return 1 + stringCount( str.substring(subLen), subStr );
        }
        else {
            return stringCount(str.substring(1), subStr );
        }
    }

    public static void main( String[] args) {
        Recursion rc = new Recursion();

        System.out.println(  "count = " + rc.stringCount( "catcowcat", ""));
    }
}
