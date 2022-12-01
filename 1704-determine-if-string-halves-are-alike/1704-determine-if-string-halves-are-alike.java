class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int count1 = 0, count2 = 0;
        count1 = numOfVowels(s,0,n/2);
        count2 = numOfVowels(s,n/2,n);
        return count1==count2;
    }
    
    public int numOfVowels(String s, int startIndex, int endIndex){
        Set<Character> seen = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for(int i=startIndex;i<endIndex;i+=1){
            char curr = s.charAt(i);
            if(seen.contains(curr))
                count+=1;
        }
        return count;
    }
}