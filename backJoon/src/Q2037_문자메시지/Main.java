package Q2037_문자메시지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] ph = {
            {},
            {},{'A','B','C'},{'D','E','F'},
            {'G','H','I'},{'J','K','L'},{'M','N','O'},
            {'P','Q','R','S'},{'T','U','V'},{'W','X','Y','Z'}
    };
    static int result = 0;
    static int btnNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        char[] arr = br.readLine().toCharArray();
        for(char ch : arr) {
            if(ch == ' ') {
                result += p;
                btnNum = 1;
            } else {
                go(ch, p, w);
            }
        }
        System.out.print(result);
    }

    public static void go(char ch, int p, int w) {
        for(int i = 2; i < ph.length; i++) {
            int sec = 0;
            for(int j = 0; j < ph[i].length; j++) {
                sec += p;
                if(btnNum == i) {
                    sec += w;
                    btnNum = 0;
                }

                if(ch == ph[i][j]) {
                    result += sec;
                    btnNum = i;
                    return;
                }
            }
        }
    }
}
