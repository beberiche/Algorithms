package Q14719_빗물;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] map = new int[r][c];
        for(int i=0; i<c; i++) {
            int n = sc.nextInt();
            for(int j=r-1;j>=0; j--) {
                if (n-- > 0) map[j][i] = 1;
                else map[j][i] = 0;
            }
        }

        int ans = 0;
        for(int i=0; i<r; i++) {
            // 이전에 1을 체크했는지 아닌지
            boolean check = false;
            // 1과 1 사이에 0을 세는 개수
            int cnt = 0;
            for(int j=0; j<c; j++) {
                if(map[i][j] == 1) {
                        // check가 아직 false 라면
                        // 이제 처음 1을 지나온 거므로
                        // 그동안 0의 갯수는 리셋한다.
                        // check가 true 라면
                        // 그동안의 0의 갯수를 더해준다.
                       if(!check) {
                           check = true;
                           cnt = 0;
                       } else {
                           ans += cnt;
                           cnt = 0;
                       }
                } else cnt++;
            }
        }
        System.out.println(ans);
    }
}
