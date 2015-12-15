package com.sywood.starbucks.siyan.ccc;

import java.util.*;

/**
 * Created by siyan on 15-12-14.
 */
public class ChancesOfWinning {


    private final static int[][] ALL_GAMES = {{0,1},{0,2},{0,3},{1,2}, {1,3},{2,3}};

    private List  _games = new ArrayList();
    private int[] _score   = {0, 0, 0, 0};

    private int _team;

    public ChancesOfWinning() {
        for( int[] m: ALL_GAMES) {
            _games.add(m);
            System.out.println(m[0]);
        }


        Scanner s = new Scanner(System.in);
        _team = s.nextInt();
        int played = s.nextInt();
        for(int i = 0; i < played; i++) {
            String[] params = s.nextLine().split(" ");
        }
    }

    private void play( String[] params ) {
        int teamA = Integer.parseInt(params[0]);
        int teamB = Integer.parseInt(params[1]);
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
        _games.remove(new int[]{teamA, teamB});
    }

    public static void main(String[] args) {
        ChancesOfWinning cw = new ChancesOfWinning();


    }
}
