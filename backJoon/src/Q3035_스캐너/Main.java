package Q3035_스캐너;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());
        String[] str = new String[R];
        for (int i = 0; i < R; i++) {
            str[i] = br.readLine();
        }
        if (ZC > 1) {
            for (int i = 0; i < R; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < C; j++) {
                    for (int k = 0; k < ZC; k++) {
                        temp.append(str[i].charAt(j));
                    }
                }
                str[i] = temp.toString();
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < ZR; j++) {
                sb.append(str[i]).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
