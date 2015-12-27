package com.sywood.starbucks.ben.Waterloo2006;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Striker on 2015-10-13.
 */
public class Waterloo20061 {
    public static HashMap setMap(int cal1, int cal2, int cal3){
        HashMap ret = new HashMap();
        ret.put(1, cal1);
        ret.put(2, cal2);
        ret.put(3, cal3);
        ret.put(4, 0);
        return ret;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        HashMap burgers = setMap(461, 431, 420);
        HashMap drinks = setMap(130, 160, 118);
        HashMap sides = setMap(100, 57, 70);
        HashMap desserts = setMap(167, 266, 75);
        System.out.print("Please enter a burger choice: ");
        int burger = input.nextInt();
        System.out.print("Please enter a side choice: ");
        int side = input.nextInt();
        System.out.print("Please enter a drink choice: ");
        int drink = input.nextInt();
        System.out.print("Please enter a dessert choice: ");
        int dessert = input.nextInt();

        int calories = 0;
        calories += (int) burgers.get(burger);
        calories += (int) drinks.get(drink);
        calories += (int) sides.get(side);
        calories += (int) desserts.get(dessert);
        System.out.println("Your total Calorie count is: " + calories);
    }
}
