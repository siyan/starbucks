package com.sywood.starbucks.ben.Euler.Forties;
import java.util.ArrayList;

public class FortyFive {
    static ArrayList<Integer> triangles = new ArrayList<>();
    static ArrayList<Integer> pentagons = new ArrayList<>();
    static ArrayList<Integer> hexagons = new ArrayList<>();
    private static boolean isTriangle(int num){
        if (pentagons.contains(num)){
            return true;
        }else{
            int triangular = 1;
            int i = triangles.size();
            while (triangular < num){
                triangular = i*(3*i-1)/2;
                if (!triangles.contains(triangular)){
                    triangles.add(triangular);
                }
                i++;
            }
            return triangular == num;
        }
    }

    private static boolean isPentagon(int num){
        if (pentagons.contains(num)){
            return true;
        }else{
            int triangular = 1;
            int i = pentagons.size();
            while (triangular < num){
                triangular = i*(3*i-1)/2;
                if (!pentagons.contains(triangular)){
                    pentagons.add(triangular);
                }
                i++;
            }
            return triangular == num;
        }
    }
    private static boolean isHexagon(int num){
        if (hexagons.contains(num)){
            return true;
        }else{
            int triangular = 1;
            int i = hexagons.size();
            while (triangular < num){
                triangular = i*(2*i-1);
                if (!hexagons.contains(triangular)){
                    hexagons.add(triangular);
                }
                i++;
            }
            return triangular == num;
        }
    }



    public static void main(String[] args){
        boolean found = false;
        int i = 286;
        while (!found){
            int temp = i*(2*i-1);
            if (isPentagon(temp) & isTriangle(temp)){
                found = true;
                System.out.println(i);
            }
            i++;
        }
    }
}
