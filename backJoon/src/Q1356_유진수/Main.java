package Q1356_유진수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        boolean check = false;
        for (int i = 0; i < N-1; i++) {
            int curr = str.charAt(i) - '0';
            int n1 = go(str,0, i);
            int n2 = go(str,i+1, N-1);

            if (n1 == n2) {
                check = true;
                break;
            }
        }

        System.out.println(check ? "YES" : "NO");
    }

    private static int go(String str, int st, int ed) {
        int num = 1;
        for (int i = st; i <= ed; i++) {
            num *= str.charAt(i) - '0';
        }
        return num;
    }
}
