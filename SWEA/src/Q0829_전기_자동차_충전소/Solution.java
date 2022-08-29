package Q0829_전기_자동차_충전소;

import java.util.*;

public class Solution {
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[31][31];

            ans = 987654321;
            Queue<int[]> q = new LinkedList<>();
            List<int[]> homeList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int range = sc.nextInt();
                map[r + 15][c + 15] = -1;
                q.add(new int[]{r + 15, c + 15, range});
                homeList.add(new int[]{r + 15, c + 15, range});
            }


            // 집 인근거리 맵에 심기
            int num = 0;
            int totalHouse = q.size();
            while (!q.isEmpty()) {
                int[] currHome = q.poll();
                for (int i = 0; i < 31; i++) {
                    for (int j = 0; j < 31; j++) {
                        if (Math.abs(i - currHome[0]) + Math.abs(j - currHome[1]) <= currHome[2]) {
                            if (map[i][j] == -1) continue;
                            else map[i][j] += 1;
                            num = Math.max(map[i][j], num);
                        }
                    }
                }
            }

            // 최대가 1인 경우는, 모든 집마다 전기 충전소가 필요하다는 것
            // 이에 대한 최소값은 바로 집 옆에 만들어주는 것이 가장 최소 거리의 합이다.
            // 인근 거리 값은 1 이므로 결국 모든 집의 갯수가 인근 거리가 된다.
            if (num == 1 && totalHouse <= 2) {
                System.out.printf("#%d %d\n", tc, totalHouse);
            } else {
                List<int[]> electricPos = new ArrayList<>();
                for (int i = 0; i < 31; i++) {
                    for (int j = 0; j < 31; j++) {
                        if (map[i][j] == num) {
                            electricPos.add(new int[]{i, j});
                        }
                    }
                }

//                int[] sel = new int[2];
                perm(0, new int[2][2], electricPos, new boolean[electricPos.size()], homeList);
                if(ans==987654321) {
                    System.out.printf("#%d %d\n", tc, -1);
                }
                System.out.printf("#%d %d\n", tc, ans);
            }


        }
    }

    public static void perm(int cnt, int[][] sel, List<int[]> electricPos, boolean[] visited, List<int[]> homeList) {
        if (cnt >= sel.length) {
            int temp = 0;
            for (int[] home : homeList) {
                int currDist = 99999;
                for (int[] electric : sel) {
                    int dist = Math.abs(electric[0] - home[0]) + Math.abs(electric[1] - home[1]);
                    currDist = Math.min(currDist, dist);
                }
                temp += currDist;
            }
            ans = Math.min(ans, temp);
            return;
        }

        for (int i = 0; i < electricPos.size(); i++) {
            if (visited[i]) continue;
            sel[cnt] = electricPos.get(i);
            visited[i] = true;
            perm(cnt + 1, sel, electricPos, visited, homeList);
            visited[i] = false;
        }
    }
}
