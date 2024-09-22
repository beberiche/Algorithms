package Q1038_감소하는_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static List<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        if (N <= 10) {
            System.out.println(N);
            return;
        }

        if (N >= Math.pow(2, 10) - 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 10; i++) {
            go(i, 1);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    private static void go(long num, int idx) {
        if (idx > 10) return;

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            go((num * 10) + i, idx + 1);
        }
    }
}

