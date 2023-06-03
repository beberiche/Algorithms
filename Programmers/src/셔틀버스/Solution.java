package 셔틀버스;

import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq;
    private static void input(String[] timetable) {
        pq = new PriorityQueue<>();
        for(int i=0; i<timetable.length; i++) {
            String[] curr = timetable[i].split(":");
            int ret = Integer.parseInt(curr[0])*60 +Integer.parseInt(curr[1]);
            pq.add(ret);
        }
    }

    private static int solve(int n, int t, int m) {
        int startTime = 540;
        int cTime = 0;
        int cnt = 0;
        for(int i=0; i<n; i++) {
            startTime = 540 + t * i;
            cnt = 0;
            while(!pq.isEmpty()) {
                int curr= pq.peek();
                if(curr <= startTime && cnt < m) {
                    pq.poll();
                    cnt++;
                    cTime = curr-1;
                } else break;
            }
        }
        if(cnt < m) cTime = startTime;
        return cTime;
    }

    private static String output(int ans) {
        String ans_t = String.valueOf(ans/60);
        String ans_m = String.valueOf(ans%60);
        ans_t = ans_t.length() < 2 ? "0" + ans_t : ans_t;
        ans_m = ans_m.length() < 2 ? "0" + ans_m : ans_m;
        return (ans_t + ":" + ans_m);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        input(timetable);
        int ret = solve(n,t,m);
        return output(ret);
    }
}