package Q1257_K번째_문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static Set<String> s1,s2;

    private static void input() throws Exception {
        s1 = new TreeSet<>();
        s2 = new TreeSet<>();
        k = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            s1.add(str.substring(i));
        }
        Iterator<String> iter = s1.iterator();
        outer:
        for (int i = 0; i < s1.size(); i++) {
            String curr_str = iter.next();
            for (int j = 1; j <= curr_str.length(); j++) {
                str = curr_str.substring(0, j);
                s2.add(str);
                if (s2.size() == k) break outer;
            }
        }
    }

    private static void output(int t) {
        if (k > s2.size()) {
            System.out.println("#" + t + " none");
        } else {
            Iterator<String> iter = s2.iterator();
            for (int i = 0; i < k-1; i++) iter.next();
            System.out.println("#" + t + " " + iter.next());
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            output(t);
        }
    }
}
