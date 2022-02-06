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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null)
            return null;
        int n = lists.length;
        ListNode dummy = new ListNode(); //dummy stores first bcz pre changes
        ListNode pre = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1,l2) -> Integer.compare(l1.val,l2.val));
        for(int i=0;i<n;i+=1){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        while(!pq.isEmpty()){
            pre.next = pq.poll();
            pre = pre.next;
            if(pre.next!=null)
                pq.add(pre.next);
        }
        return dummy.next;
    }
}