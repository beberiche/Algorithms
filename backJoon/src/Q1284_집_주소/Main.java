package Q1284_집_주소;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb=new StringBuilder();
        while (!(str = br.readLine()).equals("0")) {
            int sum = 0;
            int N = str.length();
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);

                if (ch == '0') sum += 4;
                else if (ch == '1') sum += 2;
                else sum += 3;
            }

            sb.append(sum+1+N).append("\n");
        }
        System.out.print(sb);
    }
}
