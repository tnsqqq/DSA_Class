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
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//     // base
//         if(head == null || head.next == null){
//             return true;
//         }

//     //   step1- find mid
//         ListNode mid = Findmid(head);

//     // step2- reverse 2nd half
//         ListNode prev = null;
//         ListNode curr = mid;
//         ListNode next;

//         while(curr != null){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
 
//     // step3- check left half & right half
//         ListNode right = prev; // right half head
//         ListNode left = head;

//         while(right != null){
//             if(right.val != left.val){
//                 return false;
//             }
//             left = left.next;
//             right = right.next;
//         }
//         return true;
//     }

//     public ListNode Findmid(ListNode head){
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast != null && fast.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         return slow;
//     }
// }

class Solution {
    public boolean isPalindrome(ListNode head) {

        // base 
        if(head == null && head.next == null) return true;

        // find mid
        ListNode mid = findMid(head);

        // reverse
        ListNode prev = null;
        ListNode curr = mid;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // check left & right half
        ListNode left = head;
        ListNode right = prev;

        while(right != null){
            if(left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

        public ListNode findMid(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }