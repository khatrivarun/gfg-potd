/*
 * Problem Link: https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
 * Given the head of a singly linked list, your task is to left rotate the linked list k times.
 *
 * Examples:
 * Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
 * Output: 50 -> 10 -> 20 -> 30 -> 40
 *
 * Input: head = 10 -> 20 -> 30 -> 40 , k = 6
 * Output: 30 -> 40 -> 10 -> 20
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

  public Node rotate(Node head, int k) {

    // Step 1: Get the length
    // of the linkedlist
    int length = 0;
    Node lengthNode = head;

    while (lengthNode != null) {
      length += 1;
      lengthNode = lengthNode.next;
    }

    // Step 2: Calculate the actual
    // rotations with modulus
    int actualRotations = k % length;
    Node lastNode = head;

    // Step 3: Get the last node of
    // the linked list and make it
    // circular for the time being
    while (lastNode.next != null)
      lastNode = lastNode.next;

    lastNode.next = head;

    // Step 4: Get to the first
    // node of the rotated array
    int rotationCount = 0;
    Node rotationNode = head;

    while (rotationCount < actualRotations) {
      rotationNode = rotationNode.next;
      rotationCount += 1;
    }

    Node newHead = rotationNode;

    // Step 5: Get to the element
    // before the rotation head
    // and make its next as null
    // to remove circular-ism
    rotationNode = rotationNode.next;

    while (rotationNode.next != newHead) {
      rotationNode = rotationNode.next;
    }

    rotationNode.next = null;

    return newHead;
  }

}
