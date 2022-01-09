class Solution {
    public boolean isRobotBounded(String instructions) {
      int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
      int x=0,y=0,index=0;
      for(char ch : instructions.toCharArray()){
           if(ch == 'G')
           {
               x+=dir[index][0];
               y+=dir[index][1];
           }else if(ch == 'L'){
               index = (index+1)%4;
           }else{
              index = (index+3)%4;
           }
       }
        return (x==0 && y== 0) || (index!=0);
    }
}