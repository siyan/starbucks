package com.sywood.starbucks.ben.Waterloo.Waterloo2000;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ccc00j5 {
    private static ArrayList<String> findLinks(String url){
        ArrayList<String> links = new ArrayList<>();
        for (int i = 0; i < url.length(); i++) {
            int start = url.indexOf("HREF=") + 6;
            int end = url.indexOf("\"", start);
            String link = url.substring(start, end);
            links.add(link);
            System.out.println("Link from " + url + " to " + link);
        }
        return links;
    }
    private static boolean scan(String two, ArrayList<String> links){
        for (String link : links){
            if (link.equals(two)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pages = input.nextInt();
        HashMap<String, ArrayList<String>> paths = new HashMap<>();
        while (pages > 0){
            String url = input.nextLine();
            String ret = "";
            String line = input.nextLine();
            while (!line.equalsIgnoreCase("</HTML>")){
                ret += line;
                line = input.nextLine();
            }
            paths.put(url, findLinks(ret));
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
