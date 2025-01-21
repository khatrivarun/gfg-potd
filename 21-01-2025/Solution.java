/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-
 * given-size/1
 * Given the head a linked list, the task is to reverse every k node in the
 * linked list. If the number of nodes is not a multiple of k then the left-out
 * nodes in the end, should be considered as a group and must be reversed.
 *
 * Examples:
 * Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
 * Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5
 *
 * Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
 * Output: 3 -> 2 -> 1 -> 5 -> 4
 */

import java.util.Stack;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class Solution {

  public static Node reverseKGroup(Node head, int k) {

    Stack<Node> stack = new Stack<>();
    Node headReference = head, previousNode = null;

    // Idea is to push nodes onto stack
    // till k and pop them out for the
    // reversed list
    while (headReference != null) {

      int count = 0;
      while (headReference != null && count < k) {
        stack.push(headReference);
        headReference = headReference.next;
        count += 1;
      }

      while (!stack.isEmpty()) {
        if (previousNode == null) {
          previousNode = stack.pop();
          head = previousNode;
        } else {
          previousNode.next = stack.pop();
          previousNode = previousNode.next;
        }
      }

    }

    previousNode.next = null;
    return head;

  }

}
