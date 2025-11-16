package Q10801_카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aList = new int[10];
        int[] bList = new int[10];

        for (int i = 0; i < 10; i++) {
            aList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            bList[i] = Integer.parseInt(st.nextToken());
        }

        int aCount = 0, bCount = 0, dCount = 0;

        for (int i = 0; i < 10; i++) {
            if (aList[i] > bList[i]) {
                aCount++;
            } else if (aList[i] < bList[i]) {
                bCount++;
            } else {
                dCount++;
            }
        }

        if (aCount == bCount) {
            System.out.println("D");
        } else if (aCount > bCount) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}