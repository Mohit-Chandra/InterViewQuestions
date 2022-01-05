class Solution {
    
    public List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        recur(s,0,new LinkedList<>());
        return res;
    }
    
    private void recur(String str,int index,LinkedList<String> path){
        if(str.length() == index){
            res.add(new LinkedList<>(path));
            return;
        }
        
        for(int i=index;i<str.length();i+=1){
            String prefix = str.substring(index,i+1);
            if(isPalindrome(prefix)){
                path.addLast(prefix);
                recur(str,i+1,path);
                path.removeLast();
            }
        }
    }
    
    public boolean isPalindrome(String s){
        int n = s.length();
        int i=0,j=n-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i+=1;j-=1;
        }
        return true;
    }
}