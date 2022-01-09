class Solution {
    int pos[];
    int dir[];
    public boolean isRobotBounded(String instructions) {
       pos= new int[]{0,0};
       dir = new int[]{0,1};
       for(int i=0;i<4;i+=1){
           move(instructions);
       }
        if(pos[0] == 0 && pos[1] == 0)
            return true;
        return false;
    }
    
    public void move(String str){
       for(char ch : str.toCharArray()){
           if(ch == 'G')
           {
               pos[0]+=dir[0];
               pos[1]+=dir[1];
           }else if(ch == 'L'){
               int temp = dir[0];
               dir[0] = -1 * dir[1];
               dir[1] = temp;
           }else{
              int temp = dir[0];
               dir[0] = dir[1];
               dir[1] = -1 * temp;
           }
       }
    }
}