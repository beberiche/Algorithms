package Q18870_좌표_압축;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sort_arr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sort_arr);

        Map<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int i=1; i<sort_arr.length; i++) {
            if(sort_arr[i-1] < sort_arr[i]) {
                map.put(sort_arr[i-1],val++);
            }
        }
        if(!map.containsKey(sort_arr[sort_arr.length-1])) {
            map.put(sort_arr[sort_arr.length-1], val);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++) {
            sb.append(map.get(arr[i]) + " ");
        }
        System.out.println(sb.toString());
    }
}
