package com.sywood.starbucks.siyan.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


/**
 *
 *
7 2 18
2 5 2
1 3 1
2 7 1
3 4
4 0
1 6 1
4 0
4 4
1 6 2
4 7
3 5
2 2 2
2 6 1
4 7
1 7 2
2 4 2
3 4
1 1 1
 */
public class BookShelf {

    private static List<String > _commands = new LinkedList<String>();
    private static int n, m, q;

    private BitSet[] _shelf;

    private void init() {
        _shelf = new BitSet[n];
        for (int k = 0; k < n; k++) {
            _shelf[k] = new BitSet(m);
        }
    }


    private void execute( int cmdNo ) {
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
                init();
                executeTo( i - 1 );
                break;
            default:
                System.err.println( "Something Wrong" );
        }
    }

    private void executeTo( int maxCmdNo ) {
        for( int i = 0; i <= maxCmdNo; i++ ) {
            execute( i );
            System.out.println( totBooks() );
        }
    }

    private int totBooks() {
        int tot = 0;
        for( BitSet b : _shelf ) {
            for( int c = 0; c < b.length(); c++ ) {
                if( b.get( c ) ) tot++;
            }
        }
        return tot;
    }


    public BookShelf() throws  Exception {
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
        bookShelf.executeTo( _commands.size() - 1 );

    }
}
