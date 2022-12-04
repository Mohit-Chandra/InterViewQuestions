class Solution {
    
    /**
     b->1 a->-1
    **/
    public int minSteps(String s, String t) {
        int m = s.length();
        int wordMap1[] = new int[26];
        for(int i=0;i<m;i+=1){
            wordMap1[s.charAt(i)-'a']+=1;
            wordMap1[t.charAt(i)-'a']-=1;
        }
        int res = 0;
        for(int n: wordMap1){
			if(n > 0) 
                res += n;
        }
		return res;
    }
}