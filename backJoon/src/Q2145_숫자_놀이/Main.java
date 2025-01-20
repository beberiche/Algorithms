package Q2145_숫자_놀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = br.readLine();
            if(str.equals("0")) break;

            while(str.length() > 1) {
                char[] chars = str.toCharArray();
                int sum = 0;
                for(int i=0; i<chars.length; i++) {
                    sum += (chars[i]-'0');
                }
                str = String.valueOf(sum);
            }
            sb.append(str).append("\n");
        }
        System.out.print(sb);
    }
}
