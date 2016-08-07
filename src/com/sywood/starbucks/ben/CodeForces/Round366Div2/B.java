package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B {
    private static int run(HashMap<Integer, Integer> cycles, int player){
        System.out.println(cycles);
        if (cycles.containsKey(1) && cycles.size() == 1){
            return (player%2)+1;
        }else{
            for(int key : cycles.keySet()){
                HashMap<Integer, Integer> copy = new HashMap<>();
                for (int keyy : cycles.keySet()){
                    copy.put(keyy, cycles.get(keyy));
                }
                if (key != 1 && cycles.get(key) > 0) {
                    for (int i = 1; i < key; i++) {
                        int a = i;
                        int b = key - i;
                        cycles.put(key, cycles.get(key) - 1);
                        if (!cycles.containsKey(a)) {
                            cycles.put(a, 1);
                        } else {
                            cycles.put(a, cycles.get(a) + 1);
                        }
                        if (!cycles.containsKey(b)) {
                            cycles.put(b, 1);
                        } else {
                            cycles.put(b, cycles.get(b) + 1);
                        }

                        if (run(cycles, (player % 2) + 1) == player) {
                            return player;
                        }

                    }
                }
                for (int keyy : copy.keySet()){
                    cycles.put(keyy, copy.get(keyy));
                }
            }
            return (player%2)+1;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        HashMap<Integer, Integer> cycles = new HashMap<>();
        HashMap<Integer, Integer> copy = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int t;
        for (int i = 0; i < n; i++) {
            t = Integer.parseInt(st.nextToken());
            if (!cycles.containsKey(t)){
                cycles.put(t, 1);
                copy.put(t, 1);
            }else{
                cycles.put(t, cycles.get(t)+1);
                copy.put(t, cycles.get(t)+1);
            }
            System.out.println(run(cycles, 1));
            cycles.clear();
            for(int key : copy.keySet()){
                cycles.put(key, copy.get(key));
            }
        }
    }
}
