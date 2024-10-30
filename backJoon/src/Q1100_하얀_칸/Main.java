package Q1100_하얀_칸;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 8;
        String a[] = new String[N];
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = br.readLine();
            for (int j = 0; j < N; j++) {
                if (a[i].charAt(j) == 'F' && (i + j) % 2 == 0) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
