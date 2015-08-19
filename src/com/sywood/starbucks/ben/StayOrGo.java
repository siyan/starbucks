package com.sywood.starbucks.ben;

import java.util.Scanner;

public class StayOrGo {

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please input the name of the comet: ");
        String cometName = userInput.next();
        cometName = cometName.toUpperCase();
        cometName = cometName.substring(0, 6);
        int cometTot = 1;
        for (int chr = 0; chr < cometName.length(); chr++){
            int newName = cometName.toCharArray()[chr];
            cometTot *= (newName-64);
        }
        System.out.print("Please input the name of the group: ");
        String groupName = userInput.next();
        groupName = groupName.toUpperCase();
        groupName = groupName.substring(0, 6);
        int groupTot = 1;
        for (int chr = 0; chr < groupName.length(); chr++){
            int newName = groupName.toCharArray()[chr];
            groupTot *= (newName-64);
        }
        if (groupTot % 47 == cometTot % 47){
            System.out.print("GOOOOOOOOOO!");
        }
        else{
            System.out.print("STAY");
        }
    }
}