package Q4038_단어가_등장하는_횟수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String B,S;
    static int ans;
    private static void input() throws Exception{
        B = br.readLine();
        S = br.readLine();
    }
    private static void solve() {
        int[] P = new int[B.length()];
        int j= 0;
        for(int i=1; i<S.length(); i++) {
            while(j>0 && S.charAt(i) != S.charAt(j)) j = P[j-1];
            if(S.charAt(i) == S.charAt(j)) P[i] = ++j;
        }
        ans = 0;
        j=0;
        for(int i=0; i<B.length(); i++) {
            while(j>0 && B.charAt(i)!= S.charAt(j)) j = P[j-1];
            if(B.charAt(i) == S.charAt(j)) {
                if(j== S.length()-1) {
                    ans++;
                    j = P[j];
                } else j++;
            }
        }
    }
    private static void output(int t) {
        System.out.println("#"+t+" "+ans);
    }
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            input();
            solve();
            output(t);
        }
    }
}
