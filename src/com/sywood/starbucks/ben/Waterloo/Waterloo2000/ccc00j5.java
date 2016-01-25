package com.sywood.starbucks.ben.Waterloo.Waterloo2000;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ccc00j5 {
    private static void findLinks(String url, ArrayList<String> list){
        int start = url.indexOf("HREF=");
        while(start > -1){
            start += 6;
            int end = url.indexOf("\"", start);
            String link = url.substring(start, end);
            list.add(link);
            System.out.println("Link from " + url + " to " + link);
            start = url.indexOf("HREF=", end);
        }
    }
    private static boolean scan(String two, ArrayList<String> links){
        for( String link : links ) {
            if( two.equalsIgnoreCase( link )) {
                return true;
            }
            else {
                return scan( two, paths.get( link ));
            }
        }
        return false;
    }
    private static HashMap<String, ArrayList<String>> paths = new HashMap<>();


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pages = input.nextInt();
        while (pages > 0){
            String base = input.nextLine();
            ArrayList<String> links = new ArrayList<>();
            for (String line; !"</HTML>".equalsIgnoreCase(line = input.nextLine()); ) {
                findLinks( line, links);
            }
            paths.put( base, links );
            pages--;
        }
        String one = input.nextLine();
        String two = input.nextLine();
        while(!one.equalsIgnoreCase("The End") & !two.equalsIgnoreCase("The End")){
            if (scan(two, paths.get(one))){
                System.out.println(" Can surf from " + one + " to " + two);
                if (input.hasNextLine()){
                    one = input.nextLine();
                    if (input.hasNextLine()){
                        two = input.nextLine();
                    }
                }
            }else{
                System.out.println("Can't surf from " + one + " to " + two);
            }
        }
    }
}
