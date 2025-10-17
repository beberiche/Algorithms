package Q1205_등수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int taesuScore = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        List<Integer> scores = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(stk.nextToken()));
        }

        int rank = calculateRank(scores, taesuScore, p);
        System.out.println(rank);
    }

    private static int calculateRank(List<Integer> scores, int taesuScore, int p) {
        if (scores.size() == p && scores.get(scores.size() - 1) >= taesuScore) {
            return -1;
        }

        int rank = 1;
        for (int score : scores) {
            if (score > taesuScore) {
                rank++;
            } else {
                break;
            }
        }

        return rank;
    }
}