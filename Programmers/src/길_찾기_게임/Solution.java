package 길_찾기_게임;

import java.util.*;
// y를 기준으로 내림차순 정렬, x를 기준으로 오름차순 정렬
// Node 클래스를 활용한 트리 구성
// - 삽입될 노드가 부모의 x보다 작은지 확인 && left 비어있다면 -> left 삽입
// - 삽입될 노드가 부모의 x보다 큰지 확인 && right 비어있다면 -> right 삽입
// 전위순회, 후위 순회 구하기
class Solution {
    static class TreeNode {
        int x,y,val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x,int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    };

    static List<TreeNode> list = new ArrayList<>();
    static int N, ans[][], idx, idx2;

    private static void goAnswer(TreeNode node) {
        if(node == null) return;
        ans[0][idx++] = node.val;
        goAnswer(node.left);
        goAnswer(node.right);
        ans[1][idx2++] = node.val;
    }

    private static void goSort() {
        // 정렬
        Collections.sort(list, (TreeNode t1, TreeNode t2) -> {
            if(t1.y == t2.y) return t1.x-t2.x;
            return t2.y-t1.y;
        });
    }

    private static void goTree(TreeNode parent, TreeNode child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                goTree(parent.left, child);
            }
        } else if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                goTree(parent.right, child);
            }
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        N = nodeinfo.length;
        ans = new int[2][N];
        for(int i=0; i<N; i++) {
            list.add(new TreeNode(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        goSort();
        for(int i=1; i<list.size(); i++) {
            goTree(list.get(0), list.get(i));
        }
        goAnswer(list.get(0));
        return ans;
    }
}