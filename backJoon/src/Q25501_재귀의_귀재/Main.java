package Q25501_재귀의_귀재;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(--N>=0) {
            String str = br.readLine();
            cnt = 0;
            System.out.println(isPalindrome(str,0, str.length()-1) + " " + cnt);
        }
    }

    private static int isPalindrome(String str, int st, int ed) {
        cnt++;
        if(st>=ed) return 1;
        if(str.charAt(st) != str.charAt(ed)) return 0;
        return isPalindrome(str, st+1, ed-1);
    }
}
