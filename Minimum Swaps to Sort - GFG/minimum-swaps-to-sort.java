// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        int curr[] = new int[n];
        for(int i=0;i<n;i+=1)
            curr[i] = nums[i];
        Map<Integer,Integer> hMap = new HashMap<>();
        Arrays.sort(curr);
        for(int i=0;i<n;i+=1){
            hMap.put(curr[i],i);
        }
        int count = 0;
        for(int i=0;i<n;i+=1){
            while(hMap.get(nums[i])!=i){
                count+=1;
                int temp = nums[i];
                int pos = hMap.get(nums[i]);
                nums[i] = nums[pos];
                nums[pos] = temp;
            }
        }
        return count;
    }
}