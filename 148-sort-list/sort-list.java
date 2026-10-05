// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode sortList(ListNode head) {
        
//         // 2. Divide in Left half & Right half
//         ListNode mid = slow;
//         ListNode right = mid.next;
//         mid.next = null;

//         // 3. Sort each half
//         ListNode left = sortList(head);
//         right = sortList(right);

//         // Merge
//         return merge(left, right);
//     }
    

//     // 4. Merge Sort
//     public ListNode merge(ListNode l1, ListNode l2){
        
//     }

//         // Brute Force-

//         // if(head == null) return null;

//         // List<Integer> list = new ArrayList<>();
//         // ListNode temp = head;

//         // // copy all values
//         // while(temp != null){
//         //     list.add(temp.val);
//         //     temp = temp.next;
//         // }

//         // // sort the list
//         // Collections.sort(list);

//         // // write back sorted list
//         // temp = head;
//         // for(int val : list){
//         //     temp.val = val;
//         //     temp = temp.next;
//         // }
//         // return head;

//         // Merge Sort of LL

//         // 1. Find Middle of LL
//         public ListNode mid(ListNode head){
//             ListNode slow = head;
//             ListNode fast = head;

//             while(fast != null && fast.next != null){
//                 slow = slow.next;
//                 fast = fast.next.next;
//             }
//             return slow;
//         }
// }

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

    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Divide into two halves
        ListNode rightHead = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Merge sorted halves
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }

            temp = temp.next;
        }

        // Remaining nodes
        if (left != null) {
            temp.next = left;
        }

        if (right != null) {
            temp.next = right;
        }

        return dummy.next;
    }
}


