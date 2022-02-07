class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> hMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            hMap.merge(ch,1,Integer::sum);
        }
        for(char ch : s.toCharArray()){
            if(hMap.containsKey(ch)){
                int count = hMap.get(ch)-1;
                if(count == 0)
                    hMap.remove(ch);
                else
                    hMap.put(ch,count);
            }
        }
        return hMap.keySet().iterator().next();
    }
}