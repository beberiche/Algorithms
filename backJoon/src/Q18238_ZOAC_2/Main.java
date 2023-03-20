package Q18238_ZOAC_2;

import java.util.Scanner;

public class Main {
    static String str;
    static int ans;

    private static void input() {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
    }

    private static void solve() {
        int x = 'A';
        for (int i = 0; i < str.length(); i++) {
            int y = str.charAt(i);
            int n1 = x - y < 0 ? x - y + 26 : y - x + 26;
            int n2 = x - y < 0 ? y - x : x - y;
            ans += Math.min(n1, n2);
            x = y;
        }
    }

    private static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
