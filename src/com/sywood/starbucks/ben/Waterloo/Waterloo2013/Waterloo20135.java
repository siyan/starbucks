package com.sywood.starbucks.ben.Waterloo.Waterloo2013;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20135 {
    static ArrayList<int[]> _games = new ArrayList<>();
    static int[][] _played = new int[][]{{1,2},{2,1},{1,1}};
    static int _wins = 0;
    static int _fav = -1;

    static void generate(){
        _games.add(new int[]{0,1});
        _games.add(new int[]{0,2});
        _games.add(new int[]{0,3});
        _games.add(new int[]{1,2});
        _games.add(new int[]{1,3});
        _games.add(new int[]{2,3});
    }

    static void played(int a, int b){
        for(int i = 0; i < _games.size(); i++){
            if (_games.get(i)[0] == a & _games.get(i)[1] == b){
                _games.remove(i);
                return;
            }
        }
    }

    static void hasWon(int[] scores){
        boolean won = true;
        for (int i = 0; i < scores.length; i++){
            if (scores[i] >= scores[_fav] & i != _fav){
                won = false;
            }
        }
        if (won){
            _wins++;
        }
    }
    
    static int[] win(int a, int b, int scoreA, int scoreB){
        int[] scores = new int[]{0,0,0,0};
        if (scoreB > scoreA){
            scores[b] += 3;
        }else if (scoreA > scoreB){
            scores[a] += 3;
        }else{
            scores[a] += 1;
            scores[b] += 1;
        }
        return scores;
    }

    static void simulation(int game, int[] currScores){
        int[] curr = _games.get(game);
        for (int[] result : _played){
            int[] newScore = win(curr[0], curr[1], result[0], result[1]);

            for (int i = 0; i < currScores.length; i++) newScore[i] += currScores[i];

            if (game == _games.size()-1){
                hasWon(newScore);
            }else{
                simulation(game+1, newScore);
            }
        }
    }

    public static void main(String[] args){
        generate();
        Scanner input = new Scanner(System.in);
        _fav = input.nextInt()-1;
        int iters = input.nextInt();
        int[] scores = new int[]{0,0,0,0};
        for (int i = 0; i < iters; i++){
            int a = input.nextInt()-1;
            int b = input.nextInt()-1;
            played(a, b);
            int[] score = win(a, b, input.nextInt(), input.nextInt());
            for (int j = 0; j < scores.length; j++)scores[j] += score[j];
        }

        simulation(0, scores);
        System.out.println(_wins);
    }

}
