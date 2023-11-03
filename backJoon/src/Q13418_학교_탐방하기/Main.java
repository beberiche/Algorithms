package Q13418_학교_탐방하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[][], arr2[][], sum1, sum2;

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new int[(M + 1)][3];
        arr2 = new int[(M + 1)][3];
        for (int i = 0; i < (M + 1); i++) {
            stk = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stk.nextToken());
            int n2 = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken()) == 0 ? 1 : 0;

            arr[i] = new int[]{n1, n2, dist};
            arr2[i] = new int[]{n1, n2, dist};
        }

        Arrays.sort(arr, (a1, a2) -> a1[2] - a2[2]);
        Arrays.sort(arr2, (a1, a2) -> a2[2] - a1[2]);
    }

    private static int find(int num, int[] p) {
        if (p[num] == num) {
            return num;
        }
        return p[num] = find(p[num], p);
    }

    private static void solve() {
        int[] p = new int[N + 1];
        int[] p2 = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            p[i] = i;
            p2[i] = i;
        }


        for (int i = 0; i < arr.length; i++) {
            int x1 = find(arr[i][0], p);
            int y1 = find(arr[i][1], p);

            if (x1 != y1) {
                sum1 += arr[i][2];
                if (x1 < y1) {
                    p[y1] = x1;
                } else {
                    p[x1] = y1;
                }
            }


            int x2 = find(arr2[i][0], p2);
            int y2 = find(arr2[i][1], p2);

            if (x2 != y2) {
                sum2 += arr2[i][2];
                if (x2 < y2) {
                    p2[y2] = x2;
                } else {
                    p2[x2] = y2;
                }
            }
        }


    }

    private static void output() {
        System.out.println(sum2 * sum2 - sum1 * sum1);
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }
}
