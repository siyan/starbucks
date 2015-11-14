package com.sywood.starbucks.chongc;

/**
 * Created by згёЦ on 2015/11/5.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
public class Snail {
    private static int _H;
    private static int _U;
    private static boolean _success;


    public static void main(String[] args) throws IOException{
        File f = new File("C:/File/Snail.in");
        FileReader fr = new FileReader(f);
        BufferedReader textreader = new BufferedReader(fr);


        int H = textreader.read();
        int U = textreader.read();
        int D = textreader.read();
        int F = textreader.read();
        _H = H;
        _U = U;

        do{
            int climbs=climb(H,U,D,F);
            if(_success){
                System.out.println("success on " + climbs + " days.");
            }else{
                System.out.println("failure on " + climbs + " days.");
            }
            H = textreader.read();
            U = textreader.read();
            D = textreader.read();
            F = textreader.read();
            _H = H;
            _U = U;
        }while(H!=0);

    }

    public static int climb(int location, int U, int D, int F){
        U-=F*_U/100;
        if(U<=0){
            U=0;
        }
        location+=U;
        if(location>=_H){
            _success=true;
            return 0;
        }else{
            if(location==0){
                _success=false;
                return 0;
            }else{
                location-=D;
                return 1+ climb(location,U,D,F);
            }
        }


    }



}
