package Q2033_반올림;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = (input.charAt(0)-'0') + go(input, 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length()-1; i++) {
            sb.append('0');
        }
        System.out.println(ans +sb.toString());
    }

    private static int go(String input, int idx) {
        if (idx >= input.length()) {
            return 0;
        }
        int num = input.charAt(idx) - '0' + go(input, idx + 1);
        return num >= 5 ? 1 : 0;
    }
}
