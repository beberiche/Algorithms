package Q1233_사칙연산_유효성_검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(), sb2;
        int t = 0, T = 10,N;
        boolean check;
        String[] strArr;
        String op = "+/*-";
        while (++t <= T) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            check = true;
            for(int i=0; i<N; i++) {
                strArr = br.readLine().split(" ");
                if(strArr.length >= 4 && !op.contains(strArr[1])) check = false;
            }
            sb2 = !check ? sb.append(0) : sb.append(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
