package Q12100_2048;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map, copyMap;
    static final int[] DIR = new int[] {0,1,2,3};
    static int[] sel= new int[5];
    static int ans;
    static boolean flag = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                map[i][j] = sc.nextInt();


        ans = -1;
        // 중복 순열
        perm(0);
        System.out.println(ans);
    }

    public static void perm(int idx) {
        if(idx >= sel.length) {
            copyMap = mapCopy();
            // 계산!
            calc();
            return;
        }

        for(int i=0; i<DIR.length; i++) {
            sel[idx] = DIR[i];
            perm(idx+1);
        }
    }

    public static int[][] mapCopy() {
        int[][] temp = new int[map.length][map.length];
        for(int i=0; i<temp.length; i++) {
            for(int j=0; j<temp.length; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    public static void calc() {
        // 0 = 왼쪽으로, 1 = 위쪽으로, 2 = 오른쪽으로, 3 = 아래쪽으로
            for (int d = 0; d < sel.length; d++) {
                if (sel[d] == 0) {
                    for (int i = 0; i < copyMap.length; i++) {
                        for (int j = copyMap.length - 1; j >= 1; j--) {
                            if (copyMap[i][j] == 0 && copyMap[i][j - 1] == 0) continue;
                            else if(copyMap[i][j] != 0 && copyMap[i][j-1] == 0) {
                                int zero = copyMap[i][j];
                                copyMap[i][j] = copyMap[i][j-1];
                                copyMap[i][j-1] = zero;
                            }
                            else if (copyMap[i][j] == copyMap[i][j - 1]) {
                                copyMap[i][j - 1] += copyMap[i][j];
                                copyMap[i][j] = 0;
                                j -= 1;
                            }
                        }

                        outer:
                        for (int j = 0; j < copyMap.length; j++) {
                            if (copyMap[i][j] == 0) {
                                int cnt = 1;
                                for (int k = j + 1; k < copyMap.length; k++) {
                                    if (copyMap[i][k] == 0) cnt++;
                                    else break;
                                }
                                if (j + cnt >= copyMap.length) break outer;
                                copyMap[i][j] = copyMap[i][j + cnt];
                                copyMap[i][j + cnt] = 0;
                            }
                        }
                    }
                } else if (sel[d] == 1) {
                    for (int i = 0; i < copyMap.length; i++) {
                        for (int j = copyMap.length - 1; j >= 1; j--) {
                            if (copyMap[j][i] == 0 && copyMap[j - 1][i] == 0) continue;
                            else if(copyMap[j][i] !=0 && copyMap[j-1][i] == 0) {
                                int zero = copyMap[j][i];
                                copyMap[j][i] = copyMap[j-1][i];
                                copyMap[j-1][i] = zero;
                            }
                            else if (copyMap[j][i] == copyMap[j - 1][i]) {
                                copyMap[j - 1][i] += copyMap[j][i];
                                copyMap[j][i] = 0;
                                j -= 1;
                            }
                        }

                        outer:
                        for (int j = 0; j < copyMap.length; j++) {
                            if (copyMap[j][i] == 0) {
                                int cnt = 1;
                                for (int k = j + 1; k < copyMap.length; k++) {
                                    if (copyMap[k][i] == 0) cnt++;
                                    else break;
                                }
                                if (j + cnt >= copyMap.length) break outer;
                                copyMap[j][i] = copyMap[j + cnt][i];
                                copyMap[j + cnt][i] = 0;
                            }
                        }
                    }
                } else if (sel[d] == 2) {
                    for (int i = 0; i < copyMap.length; i++) {
                        for (int j = 0; j < copyMap.length - 1; j++) {
                            if (copyMap[i][j] == 0 && copyMap[i][j + 1] == 0) continue;
                            else if(copyMap[i][j] != 0 && copyMap[i][j+1] == 0) {
                                int zero = copyMap[i][j+1];
                                copyMap[i][j+1] = copyMap[i][j];
                                copyMap[i][j] = zero;
                            }
                            else if (copyMap[i][j] == copyMap[i][j + 1]) {
                                copyMap[i][j] += copyMap[i][j + 1];
                                copyMap[i][j + 1] = 0;
                                j += 1;
                            }
                        }

                        outer:
                        for (int j = copyMap.length - 1; j >= 0; j--) {
                            if (copyMap[i][j] == 0) {
                                int cnt = 1;
                                for (int k = j - 1; k >= 0; k--) {
                                    if (copyMap[i][k] == 0) cnt++;
                                    else break;
                                }
                                if (j - cnt < 0) break outer;
                                copyMap[i][j] = copyMap[i][j - cnt];
                                copyMap[i][j - cnt] = 0;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < copyMap.length; i++) {
                        for (int j = 0; j < copyMap.length - 1; j++) {
                            if (copyMap[j][i] == 0 && copyMap[j + 1][i] == 0) continue;
                            else if(copyMap[j][i] != 0 && copyMap[j+1][i] == 0) {
                                int zero = copyMap[j+1][i];
                                copyMap[j+1][i] = copyMap[j][i];
                                copyMap[j][i] = zero;
                            }
                            else if (copyMap[j][i] == copyMap[j + 1][i]) {
                                copyMap[j][i] += copyMap[j + 1][i];
                                copyMap[j + 1][i] = 0;
                                j += 1;
                            }
                        }

                        outer:
                        for (int j = copyMap.length - 1; j >= 0; j--) {
                            if (copyMap[j][i] == 0) {
                                int cnt = 1;
                                for (int k = j - 1; k >= 0; k--) {
                                    if (copyMap[k][i] == 0) cnt++;
                                    else break;
                                }
                                if (j - cnt < 0) break outer;
                                copyMap[j][i] = copyMap[j - cnt][i];
                                copyMap[j - cnt][i] = 0;
                            }
                        }
                    }
                }
                getMax();
            }
//            System.out.println(Arrays.toString(sel));
//            System.out.println(Arrays.deepToString(copyMap));
        }


    public static void getMax() {
        for(int i=0; i< copyMap.length; i++) {
            for(int j=0; j< copyMap.length; j++) {
                ans = Math.max(ans, copyMap[i][j]);
            }
        }
    }
}


