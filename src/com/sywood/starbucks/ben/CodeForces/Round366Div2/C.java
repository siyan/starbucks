package com.sywood.starbucks.ben.CodeForces.Round366Div2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


/**
 *
 * link to blog : http://codeforces.com/blog/entry/46450
 *
 * Thor is getting used to the Earth. As a gift Loki gave him a smartphone. There are n applications on this phone.
 * Thor is fascinated by this phone. He has only one minor issue: he can't count the number of unread
 * notifications generated by those applications (maybe Loki put a curse on it so he can't).

 q events are about to happen (in chronological order). They are of three types:

 Application x generates a notification (this new notification is unread).
 Thor reads all notifications generated so far by application x (he may re-read some notifications).
 Thor reads the first t notifications generated by phone applications
 (notifications generated in first t events of the first type).
 It's guaranteed that there were at least t events of the first type before this event.
 Please note that he doesn't read first t unread notifications,
 he just reads the very first t notifications generated on his phone and he may re-read some of them in this operation.
 Please help Thor and tell him the number of unread notifications after each event.
 You may assume that initially there are no notifications in the phone.

 Input
 The first line of input contains two integers n and q (1 ≤ n, q ≤ 300 000) —
 the number of applications and the number of events to happen.

 The next q lines contain the events. The i-th of these lines starts with an integer typei —
 type of the i-th event. If typei = 1 or typei = 2 then it is followed by an integer xi.
 Otherwise it is followed by an integer ti (1 ≤ typei ≤ 3, 1 ≤ xi ≤ n, 1 ≤ ti ≤ q).

 Output
 Print the number of unread notifications after each event.

 Examples
 input
 3 4
 1 3
 1 1
 1 2
 2 3
 output
 1
 2
 3
 2
 input
 4 6
 1 2
 1 4
 1 2
 3 3
 1 3
 1 3
 output
 1
 2
 3
 0
 1
 2
 */

public class C {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printer = new PrintWriter(System.out);
        String line = input.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()), type, temp, unread = 0;
        ArrayDeque<int[]> notifications = new ArrayDeque<>();
        ArrayDeque<Integer>[] apps = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            apps[i] = new ArrayDeque<>();
        }
        boolean[] mark = new boolean[q];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(input.readLine());
            type = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken())-1;
            if(type == 1){
                unread++;
                notifications.addLast(new int[]{i, temp});
                apps[temp].addLast(i);
            }else if (type == 2){
                for(int j : apps[temp]){
                    mark[j] = true;
                    unread--;
                }
                apps[temp].clear();
            }else{
                while(!notifications.isEmpty() && notifications.peek()[0] <= temp){
                    int[] data = notifications.pop();
                    if (!mark[data[0]]){
                        mark[data[0]] = true;
                        apps[data[1]].pop();
                        unread--;
                    }
                }
            }
            printer.println(unread);
        }
        printer.close();
    }
}
