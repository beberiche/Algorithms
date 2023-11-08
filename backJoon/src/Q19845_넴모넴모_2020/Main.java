package Q19845_넴모넴모_2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q, arr[];

    private static int binarySearch(int num) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) / 2;

            if (arr[mid] <= num) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }

        return r;

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());
        arr = new int[N];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken()) - 1;
            int y = Integer.parseInt(stk.nextToken()) - 1;


            // 동일 층에서 사려져야 할 넴모
            int xx = arr[y] - x;

            // y 이상의 x가 동일한 아이들
            int yy = binarySearch(x) - y;

            int ret = yy + xx - 1;
            sb.append(ret < 0 ? 0 : ret).append("\n");
        }
        System.out.println(sb.toString());
    }
}
