package Q3059_등장하지_않는_문자의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            String line = br.readLine();
            boolean[] alpha = new boolean[26];
            for(int j = 0; j < line.length(); j++){
                if(!alpha[line.charAt(j) - 'A']) alpha[line.charAt(j) - 'A'] = true;
            }
            int ans = 0;
            int cnt = 0;
            for(int j = 0; j < alpha.length; j++){
                if(!alpha[j]){
                    ans += j;
                    cnt++;
                }
            }
            ans += cnt * 65;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
