package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siyan on 16-01-16.
 */
public class ccc00j5 {

    public static void main(String[] args) {
        String fileName = "data/surf.in";
        int lineCounter = 0;
        int numPages = 0;
        Map<String, String> links = new LinkedHashMap<String, String>();
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
                    int startPos = line.indexOf( "HREF=") + 6;
                    int endPos = line.indexOf("\"", startPos + 1 );
                    String linkUrl = line.substring( startPos, endPos );
                    links.put( url, linkUrl );
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
