package Q8949_대충_더해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String a = stk.nextToken();
        String b = stk.nextToken();

        int lengthA = a.length();
        int lengthB = b.length();
        int idxA = lengthA - 1;
        int idxB = lengthB - 1;
        while (idxA >= 0 && idxB >= 0) {
            char charA = a.charAt(idxA--);
            char charB = b.charAt(idxB--);
            int num = (charA - '0') + (charB - '0');
            if (num >= 10) {
                sb.append(new StringBuilder().append(num).reverse());
                continue;
            }
            sb.append(num);
        }
        while (idxA >= 0) {
            sb.append(a.charAt(idxA--));
        }
        while (idxB >= 0) {
            sb.append(b.charAt(idxB--));
        }
        System.out.print(sb.reverse().toString());
    }
}
