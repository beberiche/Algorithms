package Q1254_팰린드롬_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int addLength = 0;
        for (int i = 0; i < str.length(); i++) {
            if (check(str.substring(i))) break;
            addLength++;
        }

        System.out.println(str.length() + addLength);
    }

    private static boolean check(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
