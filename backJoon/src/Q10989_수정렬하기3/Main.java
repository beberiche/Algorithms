package Q10989_수정렬하기3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;

        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        int[] countArr = new int[max+1];

        for(int i=0; i<N; i++) {
            countArr[arr[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=max; i++) {
            if(countArr[i] !=0) {
                for(int j=0; j<countArr[i];j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
