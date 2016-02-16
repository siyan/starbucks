package com.sywood.starbucks.ben.Waterloo.Waterloo2011;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.jar.Pack200;

public class Waterloo20115 {
    private static int ways (ArrayList<Integer> friends, int n, int x){
        int answer = 1;
        for (int i = 0; i < n-1; i++){
            if (friends.get(i) == x){
                answer = answer*(1+ways(friends, n, i+1));
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> friends = new ArrayList<>();
        int numFriends = input.nextInt();
        for(int i = 1; i < numFriends; i++){
            friends.add(input.nextInt());
        }
        System.out.println(ways(friends, numFriends, numFriends));
    }
}
