package com.sywood.starbucks.chongc;

/**
 * Created by 赽鮿 on 2015/10/1.
 */
import java.util.Scanner;
public class CalcCalories {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Here are the three burger choices: 	     Here are the three drink choices:");
        System.out.println("1 每 Cheeseburger (461 Calories) 		     1 每 Soft Drink ( 130 Calories)");
        System.out.println("2 每 Fish Burger (431 Calories) 		      2 每 Orange Juice (160 Calories)" );
        System.out.println("3 每 Veggie Burger (420 Calories)      	  3 每 Milk (118 Calories)");
        System.out.println("4 每 no burger                             4 每 no drink ");
        System.out.println("Here are the three side order choices:     Here are the three dessert choices: ");
        System.out.println("1 每 Fries (100 Calories)                  1 每 Apple Pie (167 Calories) ");
        System.out.println("2 每 Baked Potato (57 Calories)            2 每 Sundae (266 Calories) " );
        System.out.println("3 每 Chef Salad (70 Calories)              3 每 Fruit Cup (75 Calories) ");
        System.out.println("4 每 no side order                         4 每 no dessert");
        int calories = 0;
        System.out.println("Welcome to Chip＊s Fast Food Emporium");
        System.out.println("Please enter a burger choice: ");
        int burger = input.nextInt();
        System.out.println("Please enter a side order choice: ");
        int side = input.nextInt();
        System.out.println("Please enter a drink choice:");
        int drink = input.nextInt();
        System.out.println("Please enter a dessert choice: ");
        int dessert = input.nextInt();

        if(burger==1){
            calories+=461;
        }else if(burger==2){
            calories+=431;
        }else if(burger==3){
            calories+=420;
        }

        if(side==1){
            calories+=100;
        }else if(side==2){
            calories+=57;
        }else if(side==3){
            calories+=70;
        }

        if(drink==1){
            calories+=130;
        }else if(drink==2){
            calories+=160;
        }else if(drink==3){
            calories+=118;
        }

        System.out.println("Your total Calorine is "+calories);


    }
}
