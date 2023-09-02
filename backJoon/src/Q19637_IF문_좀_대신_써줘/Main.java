package Q19637_IF문_좀_대신_써줘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        String name;
        int value;

        Node(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }

    static int N, M;
    static Node arr[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    private static void input() throws Exception {
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[i] = new Node(stk.nextToken(), Integer.parseInt(stk.nextToken()));
        }
    }


    private static void solve() throws Exception {
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (num <= arr[mid].value) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(arr[r].name).append("\n");
        }
    }

    private static void output() {
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
