package com.sywood.starbucks.ben;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * Created by Striker on 2015-10-14.
 */
public class censor {
    public static String remove(String tot, String rem){
        if (tot.length() < rem.length()){
            return tot;
        }else {
            if (tot.substring(0, rem.length()).equals(rem)) {
                return remove(tot.substring(rem.length()), rem);
            }else{
                return tot.charAt(0) + remove(tot.substring(1), rem);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 16; i++) {
            File read = new File("C://Users/Striker/Downloads/censor_silver/" + i + ".in");
            FileReader fileReader = new FileReader(read);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String use = buffReader.readLine();
            while (use.contains("moo"){
                use = remove(use, "moo");
            }
            System.out.println(use);
        }
    }
}
