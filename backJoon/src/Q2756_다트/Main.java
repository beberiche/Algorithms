package Q2756_다트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            List<Position> player1 = new ArrayList<>();
            List<Position> player2 = new ArrayList<>();

            String[] inputs = br.readLine().split(" ");
            for(int j = 0; j < 6; j++) {
                double x = Double.parseDouble(inputs[j * 2]);
                double y = Double.parseDouble(inputs[j * 2 + 1]);
                if(j < 3) {
                    player1.add(new Position(x, y));
                } else {
                    player2.add(new Position(x, y));
                }
            }

            int player1Score = getScore(player1);
            int player2Score = getScore(player2);

            System.out.print("SCORE: " + player1Score + " to " + player2Score + ", ");
            if(player1Score == player2Score) {
                System.out.println("TIE.");
            } else if(player1Score > player2Score) {
                System.out.println("PLAYER 1 WINS.");
            } else {
                System.out.println("PLAYER 2 WINS.");
            }
        }
        br.close();
    }

    static class Position {
        double x;
        double y;

        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // 플레이어의 점수를 계산하는 메서드
    static int getScore(List<Position> player) {
        int sum = 0;
        for(Position p : player) {
            double len = Math.sqrt(p.x * p.x + p.y * p.y);
            if(len <= 3) {
                sum += 100;
            } else if(len <= 6) {
                sum += 80;
            } else if(len <= 9) {
                sum += 60;
            } else if(len <= 12) {
                sum += 40;
            } else if(len <= 15) {
                sum += 20;
            }
        }
        return sum;
    }
}