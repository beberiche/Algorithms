package Q2684_동전_게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new HashMap<>();
        m.put("TTT", 0);
        m.put("TTH", 1);
        m.put("THT", 2);
        m.put("THH", 3);
        m.put("HTT", 4);
        m.put("HTH", 5);
        m.put("HHT", 6);
        m.put("HHH", 7);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int[] arr = new int[8];
            for (int j = 0; j < str.length() - 2; j++) {
                arr[m.get(str.substring(j, j + 3))]++;
            }
            for (int j = 0; j < 8; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
