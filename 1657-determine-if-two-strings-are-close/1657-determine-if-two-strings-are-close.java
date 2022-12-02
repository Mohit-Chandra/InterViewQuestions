class Solution {
    /**
        word1 = "cabbba", word2 = "abbccc"
        aabbbc
        abbccc
    **/
    
    public boolean closeStrings(String word1, String word2) {
        Map<Character,Integer> wordMap1 = new HashMap<>();
        Map<Character,Integer> wordMap2 = new HashMap<>();
        for(char ch : word1.toCharArray()){
            wordMap1.merge(ch,1,Integer::sum);
        }
        
        for(char ch : word2.toCharArray()){
            wordMap2.merge(ch,1,Integer::sum);
        }
        if(!wordMap1.keySet().equals(wordMap2.keySet()))
            return false;
        List<Integer> word1FreqList = new ArrayList<>(wordMap1.values());
        List<Integer> word2FreqList = new ArrayList<>(wordMap2.values());
        Collections.sort(word1FreqList);
        Collections.sort(word2FreqList);
        return word1FreqList.equals(word2FreqList);
        
    }
}