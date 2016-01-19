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
import java.util.stream.Collectors;

public class ccc00j5 {
    private static ArrayList<String> process(String line){
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < line.length(); i++){
            int startPos = line.indexOf("HREF=")+6<line.length()-1 ? line.indexOf("HREF=")+6 : -1;
            int endPos = line.indexOf("\"", startPos+1) < line.length()-1 ? line.indexOf("\"", startPos+1):startPos;
            ret.add(line.substring(startPos, endPos));
        }
        return ret;
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
                    if (!links.containsKey(url)) {
                        links.put(url, process(line));
                    }else{
                        ArrayList<String> extra = links.get(url);
                        extra.addAll(process(line).stream().collect(Collectors.toList()));
                        links.replace(url, links.get(url), extra);
                    }
                }
                for (String urls : links.get(url)){
                    System.out.println( "Link from " + url + " to " + urls);
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
