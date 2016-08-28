package com.sywood.starbucks.ben.SIUCFcompetitions.LocalCompetitions.Practice2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Ben on 2016-08-28.
 */
public class soccer {
    private static class Team implements Comparable<Team>{
        int wins;
        int losses;
        int ties;
        int points;
        int scored;
        int allowed;
        String name;

        public Team(String name){
            this.name = name;
            wins = 0;
            points = 0;
            scored = 0;
            allowed = 0;
            losses = 0;
            ties = 0;
        }

        public int compareTo(Team other){
            if (this.points == other.points){
                if ((this.scored-this.allowed) == (other.scored - other.allowed)){
                    if (this.scored == other.scored){
                        return this.name.compareTo(other.name);
                    }else{
                        return Integer.compare(this.scored, other.scored);
                    }
                }else{
                    return Integer.compare((this.scored-this.allowed), (other.scored -other.allowed));
                }
            }else{
                return Integer.compare(this.points, other.points);
            }
        }

        public String toString(){
            return name + " " + points + " " + wins + " " + losses + " " + ties + " " + scored + " " + allowed;
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Group " + i + ":");
            String[] data = input.readLine().split(" ");
            int T = Integer.parseInt(data[0]);
            int G = Integer.parseInt(data[1]);
            String[] names = input.readLine().split(" ");
            HashMap<String, Team> teams = new HashMap<>();
            for (int j = 0; j < T; j++) {
                teams.put(names[j], new Team(names[j]));
            }

            for (int j = 0; j < G; j++) {
                data = input.readLine().split(" ");
                String t1 = data[0];
                String t2 = data[2];
                int s2 = Integer.parseInt(data[3]);
                int s1 = Integer.parseInt(data[1]);
                if (s1 > s2){
                    teams.get(t1).wins++;
                    teams.get(t1).points += 3;
                    teams.get(t1).scored += s1;
                    teams.get(t2).allowed += s2;

                    teams.get(t2).losses++;
                    teams.get(t2).allowed += s1;
                    teams.get(t2).scored += s2;
                } else if (s2 > s1){
                    teams.get(t2).wins++;
                    teams.get(t2).points += 3;
                    teams.get(t2).scored += s2;
                    teams.get(t2).allowed += s1;

                    teams.get(t1).losses++;
                    teams.get(t1).scored += s1;
                    teams.get(t1).allowed += s2;
                } else{
                    teams.get(t1).ties++;
                    teams.get(t2).ties++;

                    teams.get(t1).points++;
                    teams.get(t2).points++;

                    teams.get(t1).allowed += s2;
                    teams.get(t1).scored += s1;
                    teams.get(t2).allowed += s1;
                    teams.get(t2).scored += s2;
                }
            }
            TreeSet<Team> t = new TreeSet<>(Collections.<Team>reverseOrder());
            for(Team team : teams.values()){
                t.add(team);
            }
            for(Team team : t){
                System.out.println(team);
            }
            System.out.println();
        }
    }
}
