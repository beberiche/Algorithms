package Q11585_속타는_저녁_메뉴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, table[];
    static String str, p;

    private static void makeTable(String p) {
        table = new int[N];
        int len = p.length();

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                j = table[j - 1];
            }
            if (p.charAt(j) == p.charAt(i)) {
                table[i] = ++j;
            }
        }
    }

    private static int solve(String str, String p) {
        int cnt = 0;
        int strLen = str.length();
        int pLen = p.length();
        int j = 0;
        for (int i = 0; i < strLen - 1; i++) {
            while (j > 0 && p.charAt(j) != str.charAt(i)) {
                j = table[j - 1];
            }
            if (p.charAt(j) == str.charAt(i)) {
                if (j == pLen - 1) {
                    cnt++;
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
        return cnt;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine().replace(" ", "");
        str += str;
        p = br.readLine().replace(" ", "");
        makeTable(p);
    }

    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private static void output(int n, int N) {
        int gcd = GCD(N, n);
        n /= gcd;
        N /= gcd;
        System.out.println(n + "/" + N);
    }

    public static void main(String[] args) throws IOException {
        input();
        int n = solve(str, p);
        output(n, N);
    }
}
