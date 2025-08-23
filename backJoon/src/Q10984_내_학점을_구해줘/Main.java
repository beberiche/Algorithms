package Q10984_내_학점을_구해줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int totalNum = 0;
            double totalScore = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(stk.nextToken());
                double score = Double.parseDouble(stk.nextToken());
                totalNum += num;
                totalScore += num * score;
            }
            sb.append(totalNum).append(" ").append(String.format("%.1f", totalScore / totalNum)).append("\n");
        }
        System.out.print(sb);
    }
}
