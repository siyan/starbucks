package com.sywood.starbucks.siyan.ccc;

import java.util.*;

/**
 * Created by siyan on 16-01-11.
 */
public class ccc15j4 {

    // map< friends id, ticker of message received>
    private static Map<Integer, Integer> _msgReceived = new HashMap<Integer, Integer>();
    private static Map<Integer, Integer> _tmWait = new HashMap<Integer, Integer>();

    private static void R( int friend, int ticker ) {

        if( _msgReceived.containsKey( friend ) ) {
            _msgReceived.remove(friend);
        }

        if( _tmWait.containsKey( friend ) ) {
            _tmWait.put( friend, -1 * _tmWait.get( friend ) );
        }
        else {
            _tmWait.put( friend, -1 );
        }

        _msgReceived.put(friend, ticker);

    }

    private static void S( int friend, int ticker ) {
        int tmwait = _tmWait.get( friend ) == -1 ? 0 : -1 * _tmWait.get( friend );

        tmwait += ticker - _msgReceived.get( friend );

        _tmWait.remove( friend );
        _tmWait.put( friend, tmwait );
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = Integer.parseInt(input.nextLine());

        int ticker = 0;
        for (int i = 0; i < iters; i++) {
            String[] line = input.nextLine().split( " " );
            int num = Integer.valueOf( line[1] );
            switch(  line[0] ) {
                case "W" :
                    ticker += (num-1);
                    break;
                case "R":
                    R( num, ticker );
                    ticker++;
                    break;
                case "S":
                    S( num, ticker );
                    ticker++;
                    break;
            }
        }

        for( Integer friend :  _tmWait.keySet() ) {
            System.out.println( friend + " " + _tmWait.get( friend ) );
        }
    }
}
