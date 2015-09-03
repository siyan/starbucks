package com.sywood.starbucks.siyan;

import java.math.BigInteger;

/**
 * Created by siyan on 8/23/15.
 */
public class Recursion {
    int stringCount( String str, String subStr ) {
        int subLen = subStr.length();

        if (str == null || str.length() < subLen) {
            return 0;
        } else if (subStr.equalsIgnoreCase(str.substring(0, subLen))) {
            return 1 + stringCount(str.substring(subLen), subStr);
        } else {
            return stringCount(str.substring(1), subStr);
        }
    }

    String allStar( String str ) {
        if(str.length() <= 1) {
            return str;
        }
        else {
            return str.substring(0, 1) + "*" + allStar( str.substring( 1 ));
        }
    }

    boolean strCopies1( String str, String subStr, int count ) {
        return count == stringCount(str, subStr);
    }

    boolean strCopies2( String str, String subStr, int count ) {
        int subLen = subStr.length();
        if( str.length() < subLen ) {
            return count == 0;
        }
        else if (subStr.equalsIgnoreCase(str.substring(0, subLen))) {
            return strCopies2(str.substring(subLen), subStr, --count);
        } else {
            return strCopies2(str.substring(1), subStr, count);
        }
    }

    String cleanStr(String str) {
        if( str == null || str.length() < 2 ) {
            return str;
        } else if ( str.charAt( 0 ) == str.charAt( 1 )) {
            return cleanStr(str.substring(1));
        }
        else {
            return str.substring(0, 1 ) + cleanStr( str.substring(1) );
        }
    }

    private String parenBit( String str ) {
        if( str == null || str.length() < 1 ) {
            return str;
        } else if ( str.charAt(0) != '(') {
            return parenBit( str.substring(1));
        } else if ( str.charAt( str.length() -1) != ')') {
            return parenBit( str.substring( 0, str.length() - 1));
        } else {
            return str;
        }
    }

    public static void main( String[] args) {
        Recursion rc = new Recursion();


        System.out.println( "count = " + rc.stringCount("catcowcat", "cat") );
        System.out.println( "All Star: " + rc.allStar("Hello") );
        System.out.println( rc.strCopies1("catcowcat", "cat", 2) );
        System.out.println( rc.strCopies1("catcowcat", "cow", 1) );
        System.out.println( rc.strCopies2("catcowcat", "cat", 2) );
        System.out.println( rc.strCopies2("catcowcat", "dog", 2) );
        System.out.println(rc.cleanStr("ccaaaatcooowcatt"));
        System.out.println(rc.parenBit("xyz(abc)123"));

    }
}
