package com.sywood.starbucks.ben;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ChancesOfWinning {


    private final static int[][] ALL_GAMES = {{0,1},{0,2},{0,3},{1,2}, {1,3},{2,3}};

    private List  _games = new ArrayList<int[]>();
    private int[] _score   = {0, 0, 0, 0};

    private int _team;

    public ChancesOfWinning() {
        for (int[] m : ALL_GAMES) {
            _games.add(m);
        }
    }

    public void readInput() {
        Scanner s = new Scanner(System.in);
        _team = Integer.parseInt(s.nextLine());
        System.out.println( "team = " +_team );
        int played = Integer.parseInt( s.nextLine() );
        System.out.println( "games played = " + played );
        for(int i = 0; i < played; i++) {
            String[] params = s.nextLine().split(" ");
            System.out.println( "params = " + params );
            playGame(params);
        }
    }

    public void predict() {
        for( Iterator itrt = _games.iterator(); itrt.hasNext(); ) {
            int[] game = (int[])itrt.next();
            System.out.println(game[0] + ", " + game[1]);
        }
    }

    private void removeGame( int tA, int tB ) {
        for( Iterator itrt = _games.iterator(); itrt.hasNext(); ) {
            int[] game = (int[])itrt.next();
            if( game[0] == tA && game[1] == tB ) {
                itrt.remove();
                break;
            }
        }
    }

    private void playGame( String[] params ) {
        int teamA = Integer.parseInt(params[0]) - 1;
        int teamB = Integer.parseInt(params[1]) - 1;
        int scoreA = Integer.parseInt(params[2]);
        int scoreB = Integer.parseInt(params[3]);

        if( scoreA > scoreB) {
            _score[teamA] += 3;
        }
        else if( scoreB > scoreA) {
            _score[teamB] += 3;
        }
        else {
            _score[teamA] += 1;
            _score[teamB] += 1;
        }
        removeGame(teamA, teamB);

    }

    public static void main(String[] args) {
        ChancesOfWinning cw = new ChancesOfWinning();
        cw.readInput();
        cw.predict();
    }
}
