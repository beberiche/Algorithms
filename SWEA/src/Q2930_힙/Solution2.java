package Q2930_힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static class MaxHead {
        int[] arr;
        int pos;

        MaxHead(int size) {
            arr = new int[size + 1];
            pos = 0;
        }

        void add(int num) {
            arr[++pos] = num;
            int idx = pos;
            while (idx > 1) {
                if (arr[idx] > arr[idx / 2]) swap(idx, idx / 2);
                idx /= 2;
            }
        }

        int pop() {
            if (pos == 0) return -1;
            int tmp = arr[1];
            arr[1] = arr[pos];
            arr[pos--] = 0;

            int idx = 1;
            while (idx * 2 <= pos) {
                // left, right 모두 큰 경우
                if (arr[idx] > arr[idx * 2] && arr[idx] > arr[idx * 2 + 1]) break;

                if (arr[idx * 2] > arr[idx * 2 + 1]) {
                    swap(idx, idx * 2);
                    idx*=2;
                } else {
                    swap(idx, idx * 2+1);
                    idx = idx*2 + 1;
                }
            }
            return tmp;
        }

        void swap(int n1, int n2) {
            int tmp = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = tmp;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            MaxHead heap = new MaxHead(N);
            StringTokenizer stk;
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(stk.nextToken());
                if (cmd == 1) {
                    heap.add(Integer.parseInt(stk.nextToken()));
                } else {
                    sb.append(heap.pop()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
