// Time complexity: O(n + m), where n and m are the lengths of the two linked lists.
// Space complexity: O(1), as we only use a constant amount of space.
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the code
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // While both lists have nodes
        while (list1 != null && list2 != null) {
            // If the current node in list1 has a smaller value, append it to the result
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                // Otherwise, append the current node in list2 to the result
                current.next = list2;
                list2 = list2.next;
            }
            // Move to the next node in the result
            current = current.next;
        }

        // If list1 has remaining nodes, append them to the result
        if (list1 != null) {
            current.next = list1;
        } else {
            // Otherwise, append the remaining nodes in list2 to the result
            current.next = list2;
        }

        // Return the result (excluding the dummy node)
        return dummy.next;
    }
}