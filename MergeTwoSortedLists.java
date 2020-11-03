/**
 *Merge two sorted linked lists and return it as a new sorted list. 
 *The new list should be made by splicing together the nodes of the first two lists.
 * @author Rahul S Koimattur
 * Intuition : Create a dummy node and keep appending nodes from both the lists while preserving the sorted
 * Order and finally return the head which is pointed to by the next pointer of the dummy node.
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum=new ListNode(0);
        ListNode itr=dum;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                itr.next=new ListNode(l1.val);
                l1=l1.next;
}
            else{
                itr.next=new ListNode(l2.val);
                l2=l2.next;
}
            itr=itr.next;
}
        itr.next=l1!=null?l1:l2;
        return dum.next;
        
    }
}