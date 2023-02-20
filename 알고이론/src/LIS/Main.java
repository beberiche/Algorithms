package LIS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,6,3,1,5};
        int N = arr.length;
        int[] dp = new int[N];
        int max = 0;
        // O(N^2) 의 방식,
        // dp 배열에 현재까지 증가하는 수를 넣는다.
        // 만약 현재 비교하는 값이 더 작은 경우, 현재 자신이 가진 증가하는 수의 값과 비교하는 값의 수+1 가운데 큰 값을 넣는다.
        for (int k = 0; k < N; k++) {
            dp[k] = 1;
            for (int i = 0; i < k; i++) {
                if (arr[i] < arr[k]) {
                    dp[k] = Math.max(dp[k], dp[i] + 1);
                    max = Math.max(max, dp[k]);
                }
            }
        }
        System.out.println(max);

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < N; i++) {
            int curr = arr[i];
            if (curr > list.get(list.size() - 1)) {
                list.add(curr);
            } else {
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if(list.get(mid)>= curr) r=mid;
                    else l=mid+1;
                }
                list.set(r, arr[i]);
            }
        }
        System.out.println(list.size());
    }

}
