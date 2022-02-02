class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if(slen<plen)
            return res;
        Map<Character,Integer> pCountMap = new HashMap<>();
        Map<Character,Integer> sCountMap = new HashMap<>();
        for(char ch : p.toCharArray()){
            pCountMap.merge(ch,1,Integer::sum);
        }
        for(int i=0;i<slen;i+=1){
            char curr = s.charAt(i);
            sCountMap.merge(curr,1,Integer::sum);
            if(i>=plen){
                curr = s.charAt(i-plen);
                if(sCountMap.get(curr) == 1)
                    sCountMap.remove(curr);
                else
                    sCountMap.put(curr,sCountMap.get(curr)-1);
            }
            
            if(pCountMap.equals(sCountMap))
                res.add(i-plen+1);
            
        }
        return res;
        
    }
}