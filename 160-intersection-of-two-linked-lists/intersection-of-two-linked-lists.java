/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Two Pointers
        if(headA == null || headB == null) return null;

        ListNode A = headA;
        ListNode B = headB;

        while(A != B){
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
    }
    return A;

    // Brute Force
    // 1. traverse headA and headB nodes 
    // 2. compare the reference of a,b not value
    // 3. return intersection
    // for(ListNode a = headA; a!=null; a=a.next){
    //     for(ListNode b = headB; b!=null; b=b.next){
    //         if(a==b){
    //             return a;
    //         }
    //     }
    // }
    // return null;
}
}