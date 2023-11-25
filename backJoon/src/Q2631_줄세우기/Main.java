package Q2631_줄세우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(num);

        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            if (list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int idx = Collections.binarySearch(list, num);
                list.set(-idx-1, num);
            }
        }

        System.out.println(N-list.size());
    }
}
