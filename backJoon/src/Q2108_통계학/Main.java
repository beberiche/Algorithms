package Q2108_통계학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int maxABS = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxABS = Math.max(maxABS,Math.abs(arr[i]));
        }

        Arrays.sort(arr);

        // 산술평균
        int result1 = 0;
        for(int i=0; i<N; i++) {
            result1 += arr[i];
        }

        // 중앙값
        int result2 = arr[N/2];

        // 최빈값
        int[][] countArr = new int[maxABS+4000+1][2];
        for(int i=0; i<N; i++) {
            countArr[arr[i]+4000][0]++;
            countArr[arr[i]+4000][1] = arr[i];
        }

        Arrays.sort(countArr, (int[] a, int[] b) -> b[0]-a[0]);
        int result3= countArr[0][0] == countArr[1][0] ? countArr[1][1] : countArr[0][1];

        // 범위
        int result4 = arr[arr.length-1] - arr[0];

        System.out.println(Math.round((double) result1/N));
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
