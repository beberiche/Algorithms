package Q2484_주사위_네개;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int reward = 0;
        int bestReward = 0;

        for (int i = 0; i < N; i++) {
            int maxDice = 0;
            int secondDice = 0;
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dice = new int[4];
            for (int j = 0; j < 4; j++) {
                dice[j] = Integer.parseInt(st.nextToken());
            }


            for (int num = 1; num <= 6; num++) {
                int tempCount = 0;
                for (int l = 0; l < dice.length; l++) {

                    if (num == dice[l]) {
                        tempCount = tempCount + 1;
                    }
                }
                if (count < tempCount && maxDice < num) {
                    count = tempCount;
                    maxDice = num;
                    secondDice = 0;
                } else if (count == tempCount && maxDice < num && count == 1) {
                    maxDice = num;
                } else if (count == tempCount) {
                    secondDice = num;
                }

            }

            if (count == 4) {
                reward = 50000 + maxDice * 5000;
            } else if (count == 3) {
                reward = 10000 + maxDice * 1000;
            } else if (count > 1 && secondDice > 0) {
                reward = 2000 + maxDice * 500 + secondDice * 500;
            } else if (count == 2) {
                reward = 1000 + maxDice * 100;
            } else if (count == 1) {
                reward = maxDice * 100;
            }

            if (reward > bestReward) bestReward = reward;
        }
        bw.write(bestReward + "");

        bw.close();
        br.close();
    }
}