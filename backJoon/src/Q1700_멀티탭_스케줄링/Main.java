package Q1700_멀티탭_스케줄링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(0);
        }

        int cnt = 0;
        for (int i = 0; i < K; i++) {
            if (list.indexOf(arr[i]) >= 0) continue;

            if (list.indexOf(0) >= 0) {
                list.set(list.indexOf(0),arr[i]);
                continue;
            }

            int maxCnt = -1;
            int currIdx = -1;
            for (int k = 0; k < N; k++) {
                int temp = 0;
                for (int j = i+1; j < K; j++) {
                    if(arr[j] == list.get(k)) break;
                    temp++;
                }
                if(temp >= maxCnt) {
                    maxCnt = temp;
                    currIdx = k;
                }
            }
            list.set(currIdx, arr[i]);
            cnt++;
        }
        System.out.println(cnt);
    }
}
