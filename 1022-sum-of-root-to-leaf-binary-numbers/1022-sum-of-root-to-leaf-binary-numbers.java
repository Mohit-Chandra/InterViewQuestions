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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        StringBuffer sb = new StringBuffer();
        return recur(root,sb);
    }
    
    public int recur(TreeNode root,StringBuffer sb){
        if(root==null)
            return 0;
        sb.append(root.val);
        if(root.left == null && root.right==null){
            return Integer.parseInt(sb.toString(),2);
        }
        int left = recur(root.left,sb);
        if(root.left!=null)
            sb.deleteCharAt(sb.length()-1);
        int right = recur(root.right,sb);
        if(root.right!=null)
            sb.deleteCharAt(sb.length()-1);
        return left+right;
    }
}