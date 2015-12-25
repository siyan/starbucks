package com.sywood.starbucks.ben;
import java.util.Scanner;
import java.util.ArrayList;

public class Waterloo20082 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("A");
        playlist.add("B");
        playlist.add("C");
        playlist.add("D");
        playlist.add("E");
        int inp = Integer.parseInt(input.nextLine());
        int numPresses = Integer.parseInt(input.nextLine());
        while (inp !=  4){
            if (inp == 1) {
                for (int i = 0; i < numPresses; i++) {
                    String move = playlist.get(0);
                    playlist.remove(0);
                    playlist.add(move);
                }
            }else if (inp == 2){
                for (int i = 0; i < numPresses; i++) {
                    String move = playlist.get(playlist.size()-1);
                    playlist.remove(playlist.size()-1);
                    playlist.add(0, move);
                }
            }else if (inp == 3){
                for (int i = 0; i < numPresses; i++) {
                    String first = playlist.get(0);
                    String second = playlist.get(1);
                    playlist.remove(0);
                    playlist.add(0, second);
                    playlist.remove(1);
                    playlist.add(1, first);
                }
            }
        }
        String ret = "";
        for (String song : playlist){
            ret += song + " ";
        }
        System.out.print(ret);
    }
}
