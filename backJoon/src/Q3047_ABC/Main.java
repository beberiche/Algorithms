package Q3047_ABC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int a[] = new int[3];

        a[0] = Integer.parseInt(stk.nextToken());
        a[1] = Integer.parseInt(stk.nextToken());
        a[2] = Integer.parseInt(stk.nextToken());

        String str = br.readLine();

        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char c = str.charAt(i);

            if (c == 'A')
                sb.append(a[0]);
            else if (c == 'B')
                sb.append(a[1]);
            else if (c == 'C')
                sb.append(a[2]);

            sb.append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}
