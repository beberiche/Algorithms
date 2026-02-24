package Sum_of_Root_To_Leaf_Binary_Numbers;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // mid, left, right 순
        return go(root, 0);
    }

    private int go(TreeNode node, int num) {
        if(node == null) {
            return 0;
        }

        num = (num << 1) | node.val;
        if(node.left == null && node.right == null) return num;
        return go(node.left, num) + go(node.right, num);
    }
}