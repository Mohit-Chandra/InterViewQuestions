/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode dummy;
    int count;
    Map<Integer,Integer> valMap;
    public Solution(ListNode head) {
        ListNode temp = head,dummy=head;
        count = 0;
        valMap = new HashMap<>();
        while(temp!=null){
            valMap.put(count,temp.val);
            count+=1;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        int randPos = random.nextInt(count);
        return valMap.get(randPos);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */