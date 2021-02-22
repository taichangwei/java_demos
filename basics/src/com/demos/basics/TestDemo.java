package com.demos.basics;

public class TestDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,3,5};

     }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = null;

        while (newHead != null) {
            ListNode temp  = newHead.next;
            newHead.next = head;
            head = newHead;
            newHead = temp;
        }
        return head;
    }
}