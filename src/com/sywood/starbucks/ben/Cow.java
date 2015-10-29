package com.sywood.starbucks.ben;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Striker on 2015-10-28.
 */
public class Cow {
    public static int minimum(int c, int o, int w){
        if (c > o & c > w){
            return c;
        }else if (o > w){
            return o;
        }else{
            return w;
        }
    }
    public static int cow(String str){
        int c = 0;
        int o = 0;
        int w = 0;
        for (int i = 0; i < str.length(); i++) {
            str = str.toLowerCase();
            char let = str.charAt(i);
            if (let == 'c'){
                c += 1;
            }else if (let == 'o'){
                o += 1;
            }else if (let == 'w'){
                w += 1;
            }
        }
        return minimum(c, o, w);
    }
    public static void main(String[] args) throws java.io.IOException{
        for (int i = 1; i < 11; i++) {
            File read = new File("C://Users/Striker/Downloads/cow_bronze/" + i + ".in");
            FileReader fileReader = new FileReader(read);
            BufferedReader buffReader = new BufferedReader(fileReader);
            buffReader.readLine();
            String use = buffReader.readLine();
            System.out.println(cow(use));
        }
    }
}
