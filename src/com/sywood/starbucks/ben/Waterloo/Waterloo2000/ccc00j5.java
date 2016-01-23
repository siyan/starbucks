package com.sywood.starbucks.ben.Waterloo.Waterloo2000;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class ccc00j5 {
    private static void findLinks(String url, ArrayList<String> list){
        int start = url.indexOf("HREF=");
        while(start > -1){
            int end = url.indexOf("\"", start);
            String link = url.substring(start, end);
            list.add(link);
            System.out.println("Link from " + url + " to " + link);
            start = url.indexOf("HREF=", end);
        }
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
        String url = input.nextLine();
        paths.put(url, new ArrayList<>());
        while (pages > 0){
            if (url.equalsIgnoreCase("</HTML>")){
                url = input.nextLine();
                paths.put(url, new ArrayList<>());
                pages--;
            }else {
                findLinks(url, paths.get(url));
                url = input.nextLine();
            }
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
