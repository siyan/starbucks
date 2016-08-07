package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        StringTokenizer st = new StringTokenizer(line);
        ArrayDeque<Integer> notifications = new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int f, app, t;
        int[] phone = new int[n];
        int[] read = new int[n];
        int[] tRead = new int[n];
        int unread = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(input.readLine());
            f = Integer.parseInt(st.nextToken());
            if(f == 1){
                app = Integer.parseInt(st.nextToken())-1;
                phone[app]++;
                unread++;
                notifications.addLast(app);
            }else if (f == 2){
                app = Integer.parseInt(st.nextToken())-1;
                t = read[app];
                read[app-1] = phone[app];
                unread -= Math.abs(t - read[app]);
            }else{
                app = Integer.parseInt(st.nextToken());
                for(int not : notifications){
                    tRead[not]++;
                    app--;
                }
                for (int j = 0; j < n; j++) {
                    if (tRead[j] > read[j]){
                        unread -= (tRead[j] - read[j]);
                    }
                    read[j] = Math.max(read[j], tRead[j]);
                }
                tRead = new int[n];
            }
            if (unread < 0){
                unread = 0;
            }
            printer.println(unread);
        }
        printer.close();
    }
}
