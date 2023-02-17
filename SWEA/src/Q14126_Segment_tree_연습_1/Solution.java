package Q14126_Segment_tree_연습_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N,Q,cmd,n1,n2;
    static StringTokenizer stk;
    static BufferedReader br;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static SegmentTree min_seg, max_seg;
    private static class SegmentTree {
        private int[] tree;
        public int tree_size;
        boolean isMax;

        SegmentTree(int size, boolean isMax) {
            int h = (int)Math.ceil((Math.log(size)/Math.log(2)));
            this.tree_size = (int)Math.pow(2,h+1);
            tree = new int[this.tree_size];
            this.isMax = isMax;
            init(1,1,size);
        }


        private int init(int node, int left, int right) {
            if(left == right) {
                return tree[node] = arr[left];
            }
            int mid = (left+right)/2;
            int left_v = init(node*2, left, mid);
            int right_v = init(node*2+1, mid+1, right);
            return tree[node] = merge(left_v, right_v);
        }

        private int find(int node, int st, int ed, int left, int right) {
            if(ed<left || right<st) {
                return isMax ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if(st<=left && right<=ed) {
                return tree[node];
            }
            int mid = (left+right)/2;
            int left_v = find(node*2, st,ed, left, mid);
            int right_v = find(node*2+1, st,ed, mid+1, right);
            return merge(left_v, right_v);
        }

        private int update(int node, int idx, int update_v, int left, int right) {
            if(idx<left || right<idx) return tree[node];

            if(left == right && left == idx) {
                return tree[node] = update_v;
            }

            int mid = (left+right)/2;
            int left_v = update(node*2, idx, update_v, left, mid);
            int right_v = update(node*2+1, idx, update_v, mid+1, right);
            return tree[node] = merge(left_v, right_v);
        }

        private int merge(int n1, int n2) {
            return isMax ? Math.max(n1,n2) : Math.min(n1,n2);
        }
    }
    private static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        arr = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        min_seg = new SegmentTree(N, false);
        max_seg = new SegmentTree(N, true);
    }

    private static void solve(int t) throws IOException {
//        System.out.printf("#%d ", t);
        sb.append("#").append(t+" ");
        for(int i=1; i<=Q; i++) {
            stk = new StringTokenizer(br.readLine());
            cmd= Integer.parseInt(stk.nextToken());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            if(cmd == 0) {
                min_seg.update(1,n1+1,n2,1, N);
                max_seg.update(1,n1+1,n2,1,N);
            } else {
                int min_v = min_seg.find(1, n1+1,n2, 1, N);
                int max_v = max_seg.find(1, n1+1,n2, 1, N);
                sb.append(max_v-min_v).append(" ");
            }
        }
        sb.append("\n");
    }
    private static void output() {
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            input();
            solve(t);
        }
        output();
    }
}
