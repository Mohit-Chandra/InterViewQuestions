class Solution {
    public boolean backspaceCompare(String s, String t) {
       String w1 = findWord(s);
       String w2 = findWord(t);
       return w1.equals(w2);
    }
    
    private String findWord(String s){
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch!='#'){
                st.add(ch);
            }else{
                if(!st.isEmpty())
                    st.pop();
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}