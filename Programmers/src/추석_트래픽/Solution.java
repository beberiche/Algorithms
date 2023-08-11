package 추석_트래픽;

import java.util.*;
class Solution {
    static class Time {
        int st;
        int ed;
        Time(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }
    }
    List<Time> list;
    private static int getTime(String line, int st, int ed) {
        return Integer.parseInt(line.substring(st,ed));
    }

    public int solution(String[] lines) {
        list = new ArrayList<>();
        for(int i=0; i<lines.length; i++) {
            int end = 0;
            int h = getTime(lines[i],11,13);
            int m = getTime(lines[i],14,16);
            int s = getTime(lines[i],17,19);
            int ms = getTime(lines[i],20,23);
            end += (h*60*60*1000) + (m*60*1000) + (s*1000) + ms;

            String tmp = lines[i].substring(24,lines[i].length()-1);

            int diff = (int)(Double.parseDouble(tmp)*1000);
            int start = end - diff + 1;
            Time t = new Time(start, end);
            list.add(t);
        }

        int ans = 1;
        for(int i=0; i<list.size(); i++) {
            int cnt = 1;
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).ed + 1000 > list.get(j).st) cnt++;
            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}