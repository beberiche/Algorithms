package Q15170_낚시터_자리잡기.solution;

import java.util.Arrays;
import java.util.Scanner;



public class Solution {
    static int N;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 태케 갯수
        final int[][] COMB = new int[][] {{0,1,2}, {0,2,1},{1,0,2}, {1,2,0}, {2,1,0}, {2,0,1}};
        for(int t=1; t<=T; t++) {
            ans = 987654321;
            N = sc.nextInt(); // 낚시터 자리 갯수
            // [[a,b]]
            // a : 낚시터의 출입구
            // b : 해당 출입구의 사람 수
            int[][] datas = new int[][] {{sc.nextInt()-1, sc.nextInt()}, {sc.nextInt()-1, sc.nextInt()}, {sc.nextInt()-1, sc.nextInt()}};

            for(int i=0; i< COMB.length; i++) {
                int[][] sel = new int[datas.length][datas[0].length];
                // 조합
                for(int a=0; a<3; a++)
                    for(int b=0; b<2; b++)
                        sel[a][b] = datas[COMB[i][a]][b];
                // go!
                DFS(0,0, sel, new int[N]);
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    // idx : 인덱스
    // dist : 총 거리
    // sel : 조합을 통한 순서
    // fishing : 낚시터 좌석
    public static void DFS(int idx, int dist, int[][] sel, int[] fishing) {
        // 넘으면 더이상 볼 필요 없음
        if(dist > ans) return;
        // 위 코드를 넘어 여기까지 왔다면, ans를 더 작은 값으로 바꾸자
        if(idx>=3) {
            ans = dist;
            return;
        }

        // 현재 출입문 번호
        int currDoor = sel[idx][0];
        // 총 사람 수
        int currPeople = sel[idx][1];

        // 짝수인 경우 : 최대 경우의 수 2가지
        // 홀수인 경우 : 경우의 수 1가지
        boolean isEven = currPeople % 2 == 0;
        if(!isEven) {
            // 해당 계층에서 얻는 dist
            int currDist = 0;
            // 이동거리
            int range = 1;
            while (currPeople > 0) {
                if(currDoor+range-1 < N && fishing[currDoor+range-1] == 0) {
                    fishing[currDoor+range-1] = 1;
                    currDist += range;
                    currPeople--;
                }
                if(currDoor-(range-1) >= 0 && fishing[currDoor-(range-1)] == 0) {
                    // currPeople != -1이 되지 않게 하기 위한 값
                    if(currPeople==0) break;
                    fishing[currDoor-(range-1)] = 1;
                    currDist += range;
                    currPeople--;
                }
                range++;
            }
            // 다음 출입문으로 이동, 구한 dist 값 반영해주고, sel은 그대로, "참조값이므로 복사해서 가기"
            DFS(idx+1,dist+currDist, sel, Arrays.copyOf(fishing, fishing.length));
        } else {
            // 일단 한명 빼기
            // 그럼 홀수식이랑 처음 전개는 같음
            currPeople--;
            int currDist = 0;
            int range = 1;
            while (currPeople > 0) {
                if(currDoor+range-1 < N && fishing[currDoor+range-1] == 0) {
                    fishing[currDoor+range-1] = 1;
                    currDist += range;
                    currPeople--;
                }
                if(currDoor-(range-1) >= 0 && fishing[currDoor-(range-1)] == 0) {
                    if(currPeople==0) break;
                    fishing[currDoor-(range-1)] = 1;
                    currDist += range;
                    currPeople--;
                }
                range++;
            }
            // 마지막에 들어가는 친구가, 두가지 경우의 수를 가지는 경우
            if(currDoor+range-1 < N && currDoor-(range-1) >= 0 && fishing[currDoor-(range-1)] == 0 && fishing[currDoor+range-1] == 0) {
                fishing[currDoor+range-1] = 1;
                // 두 경우의 수 모두 현재 구해지는 currDist 값은 동일할 테니 한번만 더해주자
                currDist += range;

                DFS(idx+1, dist+currDist,sel, Arrays.copyOf(fishing, fishing.length));
                // 원상복귀
                fishing[currDoor+range-1] = 0;
                fishing[currDoor-(range-1)] = 1;
                DFS(idx+1, dist+currDist, sel, Arrays.copyOf(fishing, fishing.length));
            } else if(currDoor+range-1 < N && fishing[currDoor+range-1] == 0) {
                fishing[currDoor+range-1] = 1;
                currDist += range;
                DFS(idx+1, dist+currDist,sel, Arrays.copyOf(fishing, fishing.length));
            } else if(currDoor-(range-1) >= 0 && fishing[currDoor-(range-1)] == 0) {
                fishing[currDoor-(range-1)] = 1;
                currDist += range;
                DFS(idx+1, dist+currDist,sel, Arrays.copyOf(fishing, fishing.length));
            }
        }
    }
}
