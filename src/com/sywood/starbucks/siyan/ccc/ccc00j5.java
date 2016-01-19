package com.sywood.starbucks.siyan.ccc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ccc00j5 {
    private static void addLink(String pageUrl, List links, String line){
        int startPos = line.indexOf("HREF=");
        while( startPos > -1 ) {
            int endPos = line.indexOf("\"", startPos+6);
            String linkUrl = line.substring( startPos+6, endPos);
            links.add( linkUrl );
            System.out.println( "Link from " + pageUrl + " to " + linkUrl );
            startPos = line.indexOf("HREF=", endPos);
        }
    }

    private static boolean hasLink( String url, List<String> links ) {
        for( String link : links ) {
            if( url.equalsIgnoreCase( link )) {
                return true;
            }
            else {
                return hasLink( url, pages.get( link ));
            }
        }
        return false;
    }


    static Map<String, List<String>> pages = new LinkedHashMap<>();

    public static void main(String[] args) {
        String fileName = "data/surf.in";
        int numPages = 0;

        String pageUrl = null;
        try ( BufferedReader br = new BufferedReader( new FileReader( fileName ) ) ) {
            numPages = Integer.valueOf( br.readLine() );
            while( numPages > 0) {
                pageUrl = br.readLine();
                List<String> links = new ArrayList<>();
                for (String line; !"</HTML>".equalsIgnoreCase(line = br.readLine()); ) {
                    addLink( pageUrl, links, line );
                }
                pages.put( pageUrl, links );
                numPages--;
            }

            for( String url; (url = br.readLine()) != null; ) {
                if( "The End".equalsIgnoreCase( url )) break;
                String linkUrl = br.readLine();
                if( hasLink( linkUrl, pages.get( url ))) {
                    System.out.println("Can surf from " + url + " to " + linkUrl);
                }
                else {
                    System.out.println("Can't surf from " + url);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
