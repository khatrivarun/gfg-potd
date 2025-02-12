// Problem Link: https://www.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
// Given a BST and an integer k, the task is to find the kth smallest element in the BST.
// If there is no kth smallest element present then return -1.
//
// Examples:
// Input: root = [2, 1, 3], k = 2
// Output: 2
//
// Input: root = [2, 1, 3], k = 5
// Output: -1
//
// Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3
// Output: 10

import java.util.LinkedList;
import java.util.List;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class Solution {

  // Construct a sorted list out of the tree
  public void inOrderTraversal(Node node, List<Integer> list) {
    if (node == null)
      return;

    inOrderTraversal(node.left, list);

    list.add(node.data);

    inOrderTraversal(node.right, list);
  }

  // Now that we have a sorted list
  // return the Kth element
  public int kthSmallest(Node root, int k) {

    List<Integer> inorderTraversal = new LinkedList<>();

    inOrderTraversal(root, inorderTraversal);

    if (k > inorderTraversal.size())
      return -1;
    else
      return inorderTraversal.get(k - 1);

  }

}
