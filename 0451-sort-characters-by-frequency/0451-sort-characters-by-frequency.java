class Solution {
    public String frequencySort(String s) {
        if(s==null || s.isEmpty())
            return s;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            freqMap.merge(ch,1,Integer::sum);
        }
        
        int maxFreq = Collections.max(freqMap.values());
        
        List<List<Character>> buckets = new ArrayList<>();
        for(int i=0;i<=maxFreq;i+=1){
            buckets.add(new ArrayList<Character>());
        }
        
        for(Character key : freqMap.keySet()){
            int freq = freqMap.get(key);
            buckets.get(freq).add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int freq=buckets.size()-1;freq>=1;freq--){
            for(Character ch : buckets.get(freq)){
                // iterate as may times as curr is present
                for(int j=0;j<freq;j+=1){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}