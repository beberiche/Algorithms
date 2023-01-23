package Q12317_기초_DFS_연습;

public class UserSolution {
    private int[][] node;
    private int[] child;
    private int kp;
    private int ans;
    public void dfs_init(int N, int[][] path) {
        node = new int[100][5];
        child = new int[100];

        for(int i=0; i<N; i++) {
            node[path[i][0]][child[path[i][0]]] = path[i][1];
            child[path[i][0]]++;
        }
    }

    public int dfs(int N) {
        kp = N;
        ans = -1;
        solve(N);
        return ans;
    }

    private void solve(int cp) {
        for(int i=0; i<5 && node[cp][i] != 0; i++) {
            if(node[cp][i] > kp){
                ans = node[cp][i];
                return;
            }
            solve(node[cp][i]);
            if(ans > -1) break;
        }
    }
}