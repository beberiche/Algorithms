package Q14733_Segment_Tree_연습_2;

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
    static SegmentTree seg;
    private static class SegmentTree {
        private long[] tree;
        public int tree_size;

        SegmentTree(int size) {
            int h = (int)Math.ceil((Math.log(size)/Math.log(2)));
            this.tree_size = (int)Math.pow(2,h+1);
            tree = new long[this.tree_size];
            init(1,1,size);
        }


        private long init(int node, int left, int right) {
            if(left == right) {
                return tree[node] = arr[left];
            }
            int mid = (left+right)/2;
            long left_v = init(node*2, left, mid);
            long right_v = init(node*2+1, mid+1, right);
            return tree[node] = merge(left_v, right_v);
        }

        private long sum(int node, int st, int ed, int left, int right) {
            if(ed<left || right<st) {
                return 0;
            }
            if(st<=left && right<=ed) {
                return tree[node];
            }
            int mid = (left+right)/2;
            long left_v = sum(node*2, st,ed, left, mid);
            long right_v = sum(node*2+1, st,ed, mid+1, right);
            return merge(left_v, right_v);
        }

        private long update(int node, int idx, int update_v, int left, int right) {
            if(idx<left || right<idx) return tree[node];

            if(left == right && left == idx) {
                return tree[node] = update_v;
            }

            int mid = (left+right)/2;
            long left_v = update(node*2, idx, update_v, left, mid);
            long right_v = update(node*2+1, idx, update_v, mid+1, right);
            return tree[node] = merge(left_v, right_v);
        }

        private long merge(long n1, long n2) {
            return n1+n2;
        }
    }
    private static void input() throws IOException {
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        Q = Integer.parseInt(stk.nextToken());

        arr = new int[N+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            if(i%2==0) {
                arr[i] = Integer.parseInt(stk.nextToken());
            } else {
                arr[i] = Integer.parseInt(stk.nextToken())*-1;
            }

        }

        seg = new SegmentTree(N);
    }

    private static void solve(int t) throws IOException {
        sb.append("#").append(t+" ");
        for(int i=1; i<=Q; i++) {
            stk = new StringTokenizer(br.readLine());
            cmd= Integer.parseInt(stk.nextToken());
            n1 = Integer.parseInt(stk.nextToken());
            n2 = Integer.parseInt(stk.nextToken());
            if(cmd == 0) {
                if(n1%2==0) n2*=-1;
                seg.update(1,n1+1,n2,1, N);
            } else {
                long sum = seg.sum(1,n1+1,n2,1, N);
                if(n1%2==0) {
                    sum*=-1;
                };
                sb.append(sum).append(" ");
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