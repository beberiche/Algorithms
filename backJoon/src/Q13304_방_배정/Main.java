package Q13304_방_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] check = new int[5];
        int total = 0;

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int grade = Integer.parseInt(stk.nextToken());

            if (s == 0) {
                if (grade == 1 || grade == 2) {
                    check[0]++;
                    if (check[0] == k) {
                        total++;
                        check[0] = 0;
                    }
                } else if (grade == 3 || grade == 4) {
                    check[1]++;
                    if (check[1] == k) {
                        total++;
                        check[1] = 0;
                    }
                } else if (grade == 5 || grade == 6) {
                    check[2]++;
                    if (check[2] == k) {
                        total++;
                        check[2] = 0;
                    }
                }
            } else {
                if (grade == 1 || grade == 2) {
                    check[0]++;
                    if (check[0] == k) {
                        total++;
                        check[0] = 0;
                    }
                } else if (grade == 3 || grade == 4) {
                    check[3]++;
                    if (check[3] == k) {
                        total++;
                        check[3] = 0;
                    }
                } else if (grade == 5 || grade == 6) {
                    check[4]++;
                    if (check[4] == k) {
                        total++;
                        check[4] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i] >= 1) {
                total++;
            }
        }
        System.out.println(total);
    }
}
