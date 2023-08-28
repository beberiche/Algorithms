package Q2295_세_수의_합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Integer arr[];
    static int N, MAX;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(arr[i], MAX);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                list.add(arr[i] + arr[j]);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = arr[i] - arr[j];
                if (num <= 0) continue;

                int l = 0;
                int r = list.size();
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) == num) {
                        System.out.println(arr[i]);
                        return;
                    } else if (list.get(mid) > num) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }

    }
}
