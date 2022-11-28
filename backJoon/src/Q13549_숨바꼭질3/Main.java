package Q13549_숨바꼭질3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] visited = new boolean[100001];

        Deque<int[]> dq= new ArrayDeque<>();

        dq.add(new int[] {N, 0});

        int ans = 0;
        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            ans = curr[1];
            if(curr[0] == K) {
                break;
            }

            if(curr[0]*2 <= 100000 && !visited[curr[0]*2]) {
                visited[curr[0]*2] = true;
                dq.addFirst(new int[] {curr[0]*2, curr[1]});
            }
            if(curr[0]+1<=K && !visited[curr[0]+1]) {
                visited[curr[0]+1] = true;
                dq.add(new int[] {curr[0]+1, curr[1]+1});
            }
            if(curr[0]-1>=0 && !visited[curr[0]-1]) {
                visited[curr[0]-1] = true;
                dq.add(new int[] {curr[0]-1, curr[1]+1});
            }
        }
        System.out.println(ans);
    }
}
