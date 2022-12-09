/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        recur(root, root.val, root.val);
        return res;
    }
    
    public void recur(TreeNode root, int max, int min){
        if(root == null)
            return;
        int possibleRes = Math.max(Math.abs(max-root.val), Math.abs(min-root.val));
        res = Math.max(possibleRes,res);
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        recur(root.left,max,min);
        recur(root.right,max,min);
        return;
    }
}