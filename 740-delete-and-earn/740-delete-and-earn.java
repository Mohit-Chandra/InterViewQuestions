class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] numsArray = new int[10001];
        for (int n: nums) numsArray[n] += n;
        int current = 0;
        int previous = 0;
        for (int num: numsArray) {
            int temp = current;
            current = Math.max(num + previous, current);
            previous = temp;
        }
        return current;
    }
}