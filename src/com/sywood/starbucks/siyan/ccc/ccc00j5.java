package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList
import java.util.Map;

/**
 * Created by siyan on 16-01-16.
 */
public class ccc00j5 {
    private static ArrayList<String> process(String line){
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < line.length(); i++){
            int startPos = line.indexOf("HREF=")+1<line.length()-1 ? line.indexOf("HREF=")+1 : -1;
            int endPos = line.indexOf("\"", startPos+1) < line.length()-1 ? line.indexOf("\"", startPos+1):startPos;
            ret.add(line.substring(startPos, endPos));
        }
        return ret;
    }
    private static boolean scan(Map<String, ArrayList<String>> links, String url){
        boolean ret = false;
        for (String key : links.keySet()){
            for (ArrayList<String> link : links.get(key)){

            }
        }
    }

    public static void main(String[] args) {
        String fileName = "data/surf.in";
        int lineCounter = 0;
        int numPages = 0;
        Map<String, ArrayList<String>> links = new LinkedHashMap<>();
        String url = null;
        try ( BufferedReader br = new BufferedReader( new FileReader( fileName ) ) ) {
            for(String line; (line = br.readLine()) != null; ) {
                if( lineCounter == 0 ) {
                    numPages = Integer.valueOf( line );
                }
                else if( lineCounter == 1 ) {
                       url = line;
                }
                else if( "</HTML>".equalsIgnoreCase( line.trim())) {
                        numPages--;
                        lineCounter = 0;
                }
                else if( line.contains("HREF")) {
                    int startPos = line.indexOf( "HREF=") + 1;
                    int endPos = line.indexOf("\"", startPos + 1 );
                    String linkUrl = line.substring( startPos, endPos );
                    links.put( url,  process(line));
                    System.out.println( "Link from " + url + " to " + linkUrl );
                }

                if( numPages == 0 ) {
                    if( "The End".equalsIgnoreCase( line )) {
                        return;
                    }
                    else {
                        System.out.println( "Surf from " + line);
                    }
                }

                lineCounter++;
                //System.out.println( line );
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
