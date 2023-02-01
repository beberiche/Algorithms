package Q12818_Inversion_Counting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long ans;
    static int[] arr;
    static int[] buf;

    private static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        buf = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        ans = 0;
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stk.nextToken());
    }

    private static void output(int t) {
        sb.append("#").append(t).append(" ").append(ans).append("\n");
    }

    private static void mergeSort(int st, int ed) {
        if (st >= ed) return;
        int mid = (st+ed)/2;
        mergeSort(st, mid);
        mergeSort(mid+1, ed);
        merge(st,mid, ed);
    }

    private static void merge(int st, int mid, int ed) {
        int l = st, r= mid+1, idx = st;
        while(l<=mid && r<=ed) {
            if(arr[l] == arr[r]) buf[idx++] = arr[r++];
            else if(arr[l] > arr[r]) {
                ans += mid - l + 1;
                buf[idx++] = arr[r++];
            } else {
                buf[idx++] = arr[l++];
            }
        }

        while(l<=mid) buf[idx++] = arr[l++];
        while(r<=ed) buf[idx++] = arr[r++];
        for(int i=st; i<=ed; i++) arr[i] = buf[i];
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            mergeSort(0, N - 1);
            output(t);
        }
        System.out.print(sb);
    }
}
