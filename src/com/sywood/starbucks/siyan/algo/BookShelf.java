package com.sywood.starbucks.siyan.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


/**
 *
 *
7 17 11
3 2
2 5 7
2 7 17
1 5 10
4 0
3 7
4 1
1 1 6
4 3
3 6
4 0
 */

public class BookShelf {

    private static List<String > _commands = new LinkedList<String>();
    private static int n, m, q;


    private BitSet[] _shelf;
    private int _tot;
    private List<Integer> _returnList = new ArrayList<Integer>();


    private Map<Integer, BitSet[]> _chkPoint;

    private void init() {
        _shelf = new BitSet[n];

        for (int k = 0; k < n; k++) {
            _shelf[k] = new BitSet(m);
        }
    }

    private BitSet[] copyBitSet( BitSet[] orig ) {
        BitSet[] cp  = new BitSet[orig.length];
        for( int i = 0; i < cp.length; i++ ) {
            cp[i] = new BitSet(m);
            cp[i].or( orig[i] )   ;
        }
        return cp;
    }

    private void saveCheckPoint( int cmdNo ) {
        if( !_chkPoint.containsKey( cmdNo ) ) {
            _chkPoint.put( cmdNo, copyBitSet(_shelf));
        }
    }


    private void execute( int cmdNo ) {
        if ( _returnList.contains( cmdNo ) ) saveCheckPoint( cmdNo );
        String[] cmd = _commands.get( cmdNo ).split( " ");
        int i = Integer.parseInt( cmd[1] ) - 1;
        int j;
        switch( cmd[0].charAt(0) ) {
            case '1':
                j = Integer.parseInt( cmd[2] ) - 1;
                _shelf[i].set( j, true );
                break;
            case '2':
                j = Integer.parseInt( cmd[2] ) - 1;
                _shelf[i].set( j, false );
                break;
            case '3':
                for( j = 0; j < m; j++ ) {
                    boolean b = _shelf[i].get( j );
                    _shelf[i].set( j, !b );
                }
                break;
            case '4':
                //init();
                //if( i > -1) executeTo( i,  false );
                _shelf = copyBitSet( _chkPoint.get( i + 1) );
                break;
            default:
                System.err.println( "Something Wrong" );
        }


    }

    private void executeTo( int maxCmdNo, boolean prt ) {
        for( int i = 0; i <= maxCmdNo; i++ ) {
            execute( i );
            if(prt) System.out.println( totBooks() );
        }
    }

    private int totBooks() {
        int tot = 0;
        for( BitSet b : _shelf ) {
            tot += b.cardinality();
        }
        return tot;
    }

    private void cheat() {
        for( String cmd : _commands ) {
            String[] c = cmd.split( " ");
            if( '4' == c[0].charAt(0) )  {
                int k =  Integer.parseInt( c[1] );
                if( ! _returnList.contains( k ))
                    _returnList.add( k );
            }
        }
    }


    public BookShelf() throws  Exception {
        _chkPoint = new HashMap<Integer, BitSet[]>();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        init();

        for( int i = 0; i < q; i++ ) {
            _commands.add( input.readLine() );
        }
    }


    public static void main(String[] args ) throws Exception {

        BookShelf bookShelf = new BookShelf();
        bookShelf.cheat();
        bookShelf.executeTo( _commands.size() - 1, true );

    }
}
