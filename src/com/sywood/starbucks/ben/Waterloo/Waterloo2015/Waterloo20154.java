package com.sywood.starbucks.ben.Waterloo.Waterloo2015;
import java.util.Scanner;
import java.util.LinkedList;

public class Waterloo20154 {
    public static int find(LinkedList<int[]> out, int friend){
        int ret = -1;
        int i = 0;
        for (int[] nums : out){
            if (nums[0] == friend){
                ret = i;
            }
            i++;
        }
        return ret;
    }
    public static boolean contains(LinkedList<Integer> in, int friend){
        for (int buddy : in){
            if (buddy == friend){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int iters = Integer.parseInt(input.nextLine());
        LinkedList<Integer> in = new LinkedList<>();
        LinkedList<int[]> out = new LinkedList<>();
        int time = 0;
        for (int i = 0; i < iters; i++) {
            String command = input.next();
            int friend = input.nextInt();
            switch (command) {
                case "R":
                    in.add(friend);
                    time++;
                    if (find(out, friend) == -1) {
                        out.add(new int[]{friend, -1, time});
                    }else{
                        out.get(find(out, friend))[2] = time;
                    }
                    break;
                case "W":
                    time += friend-1;
                    break;
                case "S":
                    in.removeFirstOccurrence(friend);
                    time++;
                    out.get(find(out,friend))[1] += time-out.get(find(out,friend))[2];
                    break;
            }
        }
        for (int[] friends : out){
            if (!contains(in, friends[0])) {
                System.out.println(friends[0] + " " + friends[1]+1);
            }else{
                System.out.println(friends[0] + " " + -1);
            }
        }
    }
}
