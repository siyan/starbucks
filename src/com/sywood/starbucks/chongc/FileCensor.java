package com.sywood.starbucks.chongc;
import com.sun.jmx.remote.protocol.iiop.ServerProvider;

import java.io.*;
import java.nio.file.Paths;

/**
 * Created by ���� on 2015/10/10.
 */
public class FileCensor {

    public static void main(String[] args) throws IOException{
        File f = new File("C:/File/FileCensor.in");
        FileReader fr = new FileReader(f);
        BufferedReader textReader = new BufferedReader(fr);

        String S = textReader.readLine();
        String T = textReader.readLine();

        textReader.close();
        String str = midtern(S,T);

        File Ff = new File("C:/File/FileCensor.out");
        if(!Ff.exists()){
            Ff.createNewFile();
        }
        FileOutputStream out =new FileOutputStream(Ff,true);
        StringBuffer strb = new StringBuffer();
        strb.append(str);
        out.write(strb.toString().getBytes("utf-8"));
        out.close();
    }

    public static String midtern(String str, String t){
        String S=str;
        do{
            S=delete(S,t);
        }while (S==delete(S,t));
        return  S;
    }

    public static String delete(String str,String t){
        if(str.length()<=t.length()){
            return str;
        }else{
            if(str.substring(0,t.length())==t){
                return delete(str.substring(t.length()),t);
            }else{
                return str.substring(0,1)+delete(str.substring(1),t);
            }
        }
    }


}
