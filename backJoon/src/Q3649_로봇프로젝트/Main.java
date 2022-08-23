package Q3649_로봇프로젝트;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int hole = sc.nextInt() * 10000000;
            int N = sc.nextInt();
            int[] blocks = new int[N];
            for (int i = 0; i < N; i++) {
                blocks[i] = sc.nextInt();
            }
            Arrays.sort(blocks);

            int st = 0;
            int ed = N-1;
            int l1 = 0;
            int l2 = 0;
            while (st < ed) {
                int temp = blocks[st] + blocks[ed];
                if (temp == hole) {
                    l1 = blocks[st];
                    l2 = blocks[ed];
                    break;
                } else if (temp > hole) {
                    ed--;
                } else if (temp < hole) {
                    st++;
                }
            }
            if (l1 == 0) {
                System.out.println("danger");
            } else {
                System.out.printf("%s %d %d\n", "yes", l1, l2);
            }
        }
        sc.close();
    }
}
