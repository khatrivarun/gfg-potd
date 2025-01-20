/*
 * Problem Link:
 * https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 * Given the head of two sorted linked lists consisting of nodes respectively.
 * The task is to merge both lists and return the head of the sorted merged
 * list.
 *
 * Examples:
 * Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
 * Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
 *
 * Input: head1 = 1 -> 1, head2 = 2 -> 4
 * Output: 1 -> 1 -> 2 -> 4
 */

class Node {
  int data;
  Node next;

  Node(int d) {
    data = d;
    next = null;
  }
}

public class Solution {

  Node sortedMerge(Node head1, Node head2) {
    Node merged = new Node(-1), mergedList = merged;
    Node listOne = head1, listTwo = head2;

    // Simple merge operation
    // a la merge sort
    while (listOne != null && listTwo != null) {

      if (listOne.data <= listTwo.data) {
        mergedList.next = new Node(listOne.data);
        mergedList = mergedList.next;

        listOne = listOne.next;
      } else {
        mergedList.next = new Node(listTwo.data);
        mergedList = mergedList.next;

        listTwo = listTwo.next;
      }

    }

    while (listOne != null) {
      mergedList.next = new Node(listOne.data);
      mergedList = mergedList.next;

      listOne = listOne.next;
    }

    while (listTwo != null) {
      mergedList.next = new Node(listTwo.data);
      mergedList = mergedList.next;

      listTwo = listTwo.next;
    }

    return merged.next;
  }

}
