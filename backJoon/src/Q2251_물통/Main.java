package Q2251_물통;

import java.util.Scanner;

public class Main {
    static boolean[][] visited = new boolean[201][201];
    static boolean[] ans = new boolean[201];
    static int A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        DFS(0, 0, C);
        for (int i = 0; i < 201; i++) if (ans[i]) System.out.print(i + " ");
    }

    public static void DFS(int a, int b, int c) {
        if (visited[a][b]) return;
        visited[a][b] = true;

        if (a == 0) ans[c] = true;
        int sum = a + b;
        if (sum > B) DFS(sum - B, B, c);
        else DFS(0, sum, c);

        sum = b + a;
        if (sum > A) DFS(A, sum - A, c);
        else DFS(sum, 0, c);

        sum = a + c;
        if (sum > C) DFS(sum - C, b, C);
        else DFS(0, b, sum);

        sum = c + a;
        if (sum > A) DFS(A, b, sum - A);
        else DFS(sum, b, 0);

        sum = b + c;
        if (sum > C) DFS(a, sum - C, C);
        else DFS(a, 0, sum);

        sum = c + b;
        if (sum > B) DFS(a, B, sum - B);
        else DFS(a, sum, 0);
    }
}
