class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            frequencyMap.merge(ch,1,Integer::sum);
        }
        ArrayList<Map.Entry<Character,Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList,(e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : entryList){
            for(int i=0;i<entry.getValue();i++)
                sb.append(entry.getKey());
        }
        return sb.toString();
    }
}