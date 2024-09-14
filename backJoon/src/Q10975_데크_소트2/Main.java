package Q10975_데크_소트2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] a2 = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
            a2[i] = a[i];
        }

        Arrays.sort(a2);

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < N; i++) {
            m.put(a2[i], i);
        }

        List<Deque<Integer>> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(m.get(a[0]));
        list.add(dq);

        for (int i = 1; i < N; i++) {
            boolean check = false;
            int idx = m.get(a[i]);
            for (Deque<Integer> d : list) {

                if (d.peekFirst() - 1 == idx) {
                    d.addFirst(idx);
                    check = true;
                    break;
                }

                if (d.peekLast() + 1 == idx) {
                    d.addLast(idx);
                    check = true;
                    break;
                }
            }

            if (!check) {
                Deque<Integer> newDq = new ArrayDeque<>();
                newDq.add(idx);
                list.add(newDq);
            }
        }

        System.out.println(list.size());
    }
}
