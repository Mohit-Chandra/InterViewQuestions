class Solution {
    public char findTheDifference(String s, String t) {
        char ch = 0;
        for(char curr : s.toCharArray())
            ch^=curr;
        for(char curr : t.toCharArray())
            ch^=curr;
        
        return ch;
    }
}