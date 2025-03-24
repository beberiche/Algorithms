package Q2816_디지털_티비;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] channels = new String[N];
        for (int i = 0; i < N; i++) {
            channels[i] = sc.nextLine();
        }

        StringBuilder result = new StringBuilder();
        int pos = 0;

        int kbs1Pos = -1;
        for (int i = 0; i < N; i++) {
            if (channels[i].equals("KBS1")) {
                kbs1Pos = i;
                break;
            }
        }

        while (pos < kbs1Pos) {
            result.append("1");
            pos++;
        }

        while (kbs1Pos > 0) {
            String temp = channels[kbs1Pos];
            channels[kbs1Pos] = channels[kbs1Pos - 1];
            channels[kbs1Pos - 1] = temp;
            result.append("4");
            kbs1Pos--;
            pos--;
        }

        int kbs2Pos = -1;
        for (int i = 0; i < N; i++) {
            if (channels[i].equals("KBS2")) {
                kbs2Pos = i;
                break;
            }
        }

        while (pos < kbs2Pos) {
            result.append("1");
            pos++;
        }

        while (kbs2Pos > 1) {
            String temp = channels[kbs2Pos];
            channels[kbs2Pos] = channels[kbs2Pos - 1];
            channels[kbs2Pos - 1] = temp;
            result.append("4");
            kbs2Pos--;
            pos--;
        }

        System.out.print(result);
    }
}