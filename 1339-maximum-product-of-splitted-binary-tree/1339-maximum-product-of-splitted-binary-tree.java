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
    
    private long maxProduct = 0;
    private int totalTreeSum = 0;
    public int maxProduct(TreeNode root) {
        this.totalTreeSum = recur(root);
        findMaxProduct(root);
        return (int)(maxProduct%1000000007);
    }
    
    public int recur(TreeNode root){
        if(root == null)
            return 0;
        int left  = recur(root.left);
        int right = recur(root.right);
        int totalSum = root.val+left+right;
        return totalSum;
    }
    
    private int findMaxProduct(TreeNode root){
        if(root == null)
            return 0;
        int leftSum = findMaxProduct(root.left);
        int rightSum = findMaxProduct(root.right);
        int totalSum = leftSum+rightSum+root.val;
        long totalProduct = (long)totalSum*(totalTreeSum - totalSum);
        this.maxProduct = Math.max(this.maxProduct,totalProduct);
        return totalSum;
    }
}