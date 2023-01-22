package Q1233_사칙연산_유효성_검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 0, T = 10;
        while (++t <= T) {
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            boolean check = true;
            for(int i=0; i<N; i++) {
                String[] strArr = br.readLine().split(" ");
                if(strArr.length >= 4 && strArr[1].matches("[0-9]+")) check = false;
            }

            if(!check) sb.append(0);
            else sb.append(1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
