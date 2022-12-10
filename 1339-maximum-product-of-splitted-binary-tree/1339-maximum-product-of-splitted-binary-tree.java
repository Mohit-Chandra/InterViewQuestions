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
    long res = 0;
    List<Integer> sumList;
    public int maxProduct(TreeNode root) {
        if(root == null)
            return 0;
        sumList = new ArrayList<>();
        int sumOfTree = recur(root);
        for(long sum : sumList){
            res = Math.max(res, sum*(sumOfTree - sum));
        }
        return (int)(res%1000000007);
    }
    
    public int recur(TreeNode root){
        if(root == null)
            return 0;
        int left  = recur(root.left);
        int right = recur(root.right);
        int totalSum = root.val+left+right;
        sumList.add(totalSum);
        return totalSum;
    }
}