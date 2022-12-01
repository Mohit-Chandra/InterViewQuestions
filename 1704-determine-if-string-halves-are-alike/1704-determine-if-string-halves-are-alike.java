class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int n = s.length();
        
        Set<Character> seen = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for(int i=0;i<n/2;i+=1){
            char curr = s.charAt(i);
            if(seen.contains(curr))
                count+=1;
        }
        
        for(int j=n/2;j<n;j++){
            char curr = s.charAt(j);
            if(seen.contains(curr))
               count-=1;
        }
        return count==0;
    }
}