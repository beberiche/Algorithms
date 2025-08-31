package Q2485_가로수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int first = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        a[0] = first;
        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            a[i] = num;
            diff.add(a[i] - a[i - 1]);
        }

        Set<Integer> s = new HashSet<>(diff);

        int gcd = s.stream().reduce(Main::gcd).orElse(1);
        // (a[N - 1] - a[0]) / gcd  -> 최소공차를 통한 필요한 나무의 수
        //  (N-1) -> 심어진 나무의 수가 N개면 간격읜 N-1개
        int result = (a[N - 1] - a[0]) / gcd - (N - 1);
        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
