package Q8595_히든_넘버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine().replaceAll("[^0-9]", " "));
        while (stk.hasMoreTokens()) {
            sum += Integer.parseInt(stk.nextToken());
        }
        System.out.print(sum);
    }
}
