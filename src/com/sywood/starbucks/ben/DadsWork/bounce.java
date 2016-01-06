package com.sywood.starbucks.ben.DadsWork;
import java.io.*;

/**
 * Created by Striker on 2015-10-18.
 */
public class bounce {
    public static void main(String[] args) throws IOException {
        File file = new File("C://Users/Striker/Downloads/THERE1.IN");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int steps = Integer.parseInt(bufferedReader.readLine());
        String iter = bufferedReader.readLine();
        for (int i = 0; i < Integer.parseInt(iter); i++) {
            if (i == 0){
                String use = bufferedReader.readLine().replaceAll(" ", "");

            }
        }

    }
}
