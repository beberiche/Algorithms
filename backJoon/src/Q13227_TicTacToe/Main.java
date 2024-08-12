package Q13227_TicTacToe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = new String[3];
        for (int i = 0; i < 3; i++) {
            a[i] = br.readLine();
            if(valid(a[i])) {
                System.out.println("YES");
                return;
            }
        }

        for(int i=0; i<3; i++) {
            String s = String.valueOf(a[0].charAt(i)) + a[1].charAt(i) + a[2].charAt(i);
            if (valid(s)) {
                System.out.println("YES");
                return;
            }
        }

        String s1 = String.valueOf(a[0].charAt(0)) + a[1].charAt(1) + a[2].charAt(2);
        if (valid(s1)) {
            System.out.println("YES");
            return;
        }
        String s2 = String.valueOf(a[0].charAt(2)) + a[1].charAt(1) + a[2].charAt(0);
        if (valid(s2)) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }

    private static boolean valid(String str) {
        return str.equals("XXX") || str.equals("OOO");
    }
}
