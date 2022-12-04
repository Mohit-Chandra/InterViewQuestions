class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        int wordMap1[] = new int[26];
        int wordMap2[] = new int[26];
        int wordBit1 = 0;
        int wordBit2 = 0;
        for(char ch : word1.toCharArray()){
            wordMap1[ch-'a']++;
            wordBit1 = wordBit1 | (1<<(ch-'a'));
        }
        
        for(char ch : word2.toCharArray()){
            wordMap2[ch-'a']++;
            wordBit2 = wordBit2 | (1<<(ch-'a'));
        }
        if(wordBit1!=wordBit2)
            return false;
        Arrays.sort(wordMap1);
        Arrays.sort(wordMap2);
        for(int i=0;i<26;i+=1){
            if(wordMap1[i] != wordMap2[i])
                return false;
        }
        return true;
    }
}