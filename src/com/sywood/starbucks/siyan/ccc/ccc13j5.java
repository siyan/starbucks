package com.sywood.starbucks.siyan.ccc;

import java.util.*;

/**
 * Created by siyan on 16-02-14.
 */
public class ccc13j5 {
    private static List<int[]> _games = new ArrayList();

    static int[][] _mockScores = new int[][]{ { 1, 2}, {2, 1}, {1, 1} };
    static int _wins = 0;

    static void initGames() {
        _games.add(new int[]{0, 1}) ;
        _games.add(new int[]{0, 2}) ;
        _games.add(new int[]{0, 3}) ;
        _games.add(new int[]{1, 2}) ;
        _games.add(new int[]{1, 3}) ;
        _games.add(new int[]{2, 3}) ;
    }

    static void gamePlayed( int a, int b ) {
        for( Iterator itrt = _games.iterator(); itrt.hasNext(); ) {
            int[] game = (int[]) itrt.next();
            if( game[0] == a && game[1] == b ) {
                itrt.remove();
                return;
            }
        }
    }

    static int[] calcScore(int a, int b, int scoreA, int scoreB ){
        int[] scores = new int[]{0, 0, 0, 0};
        if (scoreA > scoreB) {
            scores[a] = 3;
        }
        else if (scoreA < scoreB ) {
            scores[b] = 3;
        }
        else {
            scores[a] = 1;
            scores[b] = 1;
        }
        return scores;
    }

    static void favoriteWin( int fav, int[] newScore ) {
        boolean won = true;
        for (int i = 0; i < 4; i++){
            if (newScore[fav] <= newScore[i] & fav != i){
                won = false;
            }
        }
        if( won ) {
            _wins++;
        }
    }

    static void recGames( int gameIdx, int fav, int[] teamScores ) {

        int[] game = _games.get( gameIdx );

        for(int[] mockscore : _mockScores) {
            int[] scores = calcScore(game[0], game[1], mockscore[0], mockscore[1]);
            for( int j = 0; j < scores.length; j++ ) scores[j] += teamScores[j];

            if( gameIdx == _games.size() - 1 ) {
                favoriteWin( fav, scores );
            }
            else {
                recGames( gameIdx + 1, fav, scores );
            }
        }

    }

    public static void main(String[] args){

        initGames();

        Scanner input = new Scanner(System.in);
        int fav = input.nextInt()-1;
        int iter = input.nextInt();
        int[] teamScores = new int[]{0,0,0,0};

        for (int i = 0; i < iter; i++) {
            int a = input.nextInt()-1;
            int b = input.nextInt()-1;
            gamePlayed( a, b );

            int[] scores = calcScore(a, b, input.nextInt(), input.nextInt() );
            for( int j = 0; j < scores.length; j ++ ) teamScores[j] += scores[j];
        }


        recGames( 0, fav, teamScores );

        System.out.println( _wins );
    }
}
