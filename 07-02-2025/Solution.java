// Problem Link: https://www.geeksforgeeks.org/problems/inorder-traversal/1
// An inorder traversal first visits the left child (including its entire subtree),
// then visits the node, and finally visits the right child (including its entire subtree).
//
// Examples:
// Input: root[] = [1, 2, 3, 4, 5]
// Output: [4, 2, 5, 1, 3]
//
// Input: root[] = [8, 1, 5, N, 7, 10, 6, N, 10, 6]
// Output: [1, 7, 10, 8, 6, 10, 5, 6]

import java.util.ArrayList;

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class Solution {

  void runInOrderTraversal(Node root, ArrayList<Integer> traversal) {

    if (root == null)
      return;

    runInOrderTraversal(root.left, traversal);
    traversal.add(root.data);
    runInOrderTraversal(root.right, traversal);

  }

  // Pretty self explanatory
  ArrayList<Integer> inOrder(Node root) {
    ArrayList<Integer> traversal = new ArrayList<>();

    runInOrderTraversal(root, traversal);

    return traversal;
  }

}
