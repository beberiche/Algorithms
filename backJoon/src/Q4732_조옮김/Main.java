package Q4732_조옮김;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String[] scale = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
        int move = 0;
        StringBuilder sb = new StringBuilder();
        while (stk.countTokens() > 2) {
            move = Integer.parseInt(br.readLine());
            int index = 0;
            while (stk.countTokens() > 0) {
                String s = stk.nextToken();
                switch (s) {
                    case "A":
                        index = 0;
                        break;
                    case "A#":
                    case "Bb":
                        index = 1;
                        break;
                    case "B":
                    case "Cb":
                        index = 2;
                        break;
                    case "B#":
                    case "C":
                        index = 3;
                        break;
                    case "C#":
                    case "Db":
                        index = 4;
                        break;
                    case "D":
                        index = 5;
                        break;
                    case "D#":
                    case "Eb":
                        index = 6;
                        break;
                    case "E":
                    case "Fb":
                        index = 7;
                        break;
                    case "E#":
                    case "F":
                        index = 8;
                        break;
                    case "F#":
                    case "Gb":
                        index = 9;
                        break;
                    case "G":
                        index = 10;
                        break;
                    case "G#":
                    case "Ab":
                        index = 11;
                        break;
                }
                if (index + move < 0) index += 12;
                sb.append(scale[(index + move) % 12]).append(" ");
            }
            sb.append("\n");
            stk = new StringTokenizer(br.readLine());
        }
        System.out.print(sb);
    }
}
