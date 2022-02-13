class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m)
            return false;
        int count1[] = new int[26];
        int count2[] = new int[26];
        for(int i=0;i<n;i+=1){
            count1[s1.charAt(i)-'a']+=1;
        }
        
        for(int i=0;i<m;i+=1){
            char curr = s2.charAt(i);
            count2[curr-'a']+=1;
            if(i>=n){
                curr = s2.charAt(i-n);
                count2[curr-'a']-=1;
            }
            if(Arrays.equals(count1,count2))
                return true;
        }
        return false;
    }
}