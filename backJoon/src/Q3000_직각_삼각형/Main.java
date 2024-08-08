package Q3000_직각_삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][2];

        HashMap<Integer, Integer> mx = new HashMap<>();
        HashMap<Integer, Integer> my = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());

            mx.compute(a[i][0], (k, v) -> v == null ? 1 : v + 1);
            my.compute(a[i][1], (k, v) -> v == null ? 1 : v + 1);
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += 1L * (mx.get(a[i][0]) - 1) * (my.get(a[i][1]) - 1);
        }
        System.out.println(result);
    }
}
