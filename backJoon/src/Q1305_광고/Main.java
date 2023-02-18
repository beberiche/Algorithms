package Q1305_광고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,ans;
    static String str;
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }

    private static void makeTable() {
        int[] table = new int[N];
        int j = 0;
        for(int i=1; i<N; i++) {
            while(j>0 && str.charAt(i) != str.charAt(j)) {
                j = table[j-1];
            }
            if(str.charAt(i) == str.charAt(j)) {
                table[i] = ++j;
            }
        }
        ans = N-table[N-1];
    }
    private static void output() {
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        makeTable();
        output();
    }
}
