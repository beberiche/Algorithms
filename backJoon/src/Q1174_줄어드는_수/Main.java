package Q1174_줄어드는_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> list = new ArrayList<>();

        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int i = 1; i < (1 << 10); i++) {
            long num = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) > 0) {
                    num = num * 10 + a[j];
                }
            }
            list.add(num);
        }


        if(N > list.size()) {
            System.out.println(-1);
        } else {
            Collections.sort(list);
            System.out.println(list.get(N - 1));
        }
    }
}
