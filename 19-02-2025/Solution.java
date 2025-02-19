// Problem Link: https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
// Given an array arr[] of n sorted linked lists of different sizes. The task is to
// merge them in such a way that after merging they will be a single sorted linked list,
// then return the head of the merged linked list.
//
// Examples:
// Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
// Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
//
// Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
// Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8

import java.util.List;
import java.util.PriorityQueue;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

public class Solution {

  Node mergeKLists(List<Node> arr) {

    // We use a min heap to save all the heads of the linked lists
    // so when we poll the heap, we get the minimum possible value
    PriorityQueue<Node> minHeap = new PriorityQueue<>((Node nodeOne, Node nodeTwo) -> nodeOne.data - nodeTwo.data);

    for (Node node : arr) {
      minHeap.add(node);
    }

    Node resultList = new Node(-1), resultReference = resultList;

    // While polling, if the node has
    // a next element, we add that back
    // in the heap
    //
    // We loop till the min heap is
    // empty
    while (!minHeap.isEmpty()) {

      Node minNode = minHeap.poll();
      int minData = minNode.data;

      resultReference.next = new Node(minData);
      resultReference = resultReference.next;

      if (minNode.next != null) {
        minHeap.add(minNode.next);
      }

    }

    return resultList.next;

  }

}
