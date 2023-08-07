package Q10798_세로읽기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char arr[][];

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
    }

    private static void solve() {
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                System.out.print(arr[j][i] == '\u0000' ? "" : arr[j][i]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        solve();
    }
}
