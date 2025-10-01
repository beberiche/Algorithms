package Q13866_팀_나누기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(a);
        System.out.println(Math.abs(a[0] + a[3] - (a[1] + a[2])));
    }
}
