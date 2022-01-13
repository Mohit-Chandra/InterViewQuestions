class Solution {
    public int climbStairs(int n) {
        if(n<=3)
            return n;
        int prev=3,pp=2;
        for(int i=4;i<=n;i+=1){
            int temp = prev;
            prev = prev+pp;
            pp = temp;
        }
        return prev;
    }
}