package com.sywood.starbucks.chongc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by згёЦ on 2015/9/25.
 */
public class There {

    private static int vertical=1;
    private static int horizonal=1;

    public static int checkbound(boolean north, boolean east,int X,int Y ,int AX, int AY,int BX,int BY){
        if(!north){
            vertical = -1;
        }else{
            vertical= 1;
        }
        if(!east){
            horizonal= -1;
        }else{
            horizonal= 1;
        }

        if(AX==X||AX==0){
            horizonal*=-1;
            east = !east;
        }
        if(AY==Y||AY==0){
            vertical*=-1;
            north = !north;
        }

        if(!moves(north,east,AX,AY,BX,BY,X,Y)){
            return 1;
        }else{
            return 0;
        }

    }

    public static boolean moves(boolean north, boolean east,int X,int Y ,int AX, int AY,int BX,int BY){
        if(AX+horizonal==BX && AY+vertical ==BY){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        File f = new File("C:/File/THERE.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);
        int count = textReader.read();

        for(int i=1;i<=count;i++){

            int stepsCount=0;
            boolean N=true;
            boolean E=true;
            int X=textReader.read();
            int Y=textReader.read();
            int AX=textReader.read();
            int AY=textReader.read();
            int BX=textReader.read();
            int BY=textReader.read();



            do{
                if(checkbound(N,E,X,Y,AX,AY,BX,BY)==0){
                    System.out.println("B can be reached from A after "+stepsCount+" move(s).");
                    break;
                }else{
                    stepsCount+=1;
                    if(vertical==1){
                        N=true;
                    }else{
                        N=false;
                    }

                    if(horizonal==1){
                        E=true;
                    }else{
                        E=false;
                    }

                    AX+=horizonal;
                    BX+=vertical;



                }
            }while(1==1);













        }



    }
}
