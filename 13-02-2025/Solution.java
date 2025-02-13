// Problem Link: https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the
// BST with value summing up to the target.
//
// Examples:
// Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
// Output: True
//
// Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
// Output: False

import java.util.ArrayList;

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class Solution {

  // Convert BST into a sorted array using inorder traversal
  void inOrderTraversal(Node node, ArrayList<Integer> traversal) {
    if (node == null)
      return;

    inOrderTraversal(node.left, traversal);

    traversal.add(node.data);

    inOrderTraversal(node.right, traversal);
  }

  // Two pointer approach for finding the
  // sum pair
  boolean findTarget(Node root, int target) {

    ArrayList<Integer> sortedBstArray = new ArrayList<>();

    inOrderTraversal(root, sortedBstArray);

    int leftCounter = 0, rightCounter = sortedBstArray.size() - 1;

    while (leftCounter < rightCounter) {

      int sum = sortedBstArray.get(leftCounter) + sortedBstArray.get(rightCounter);

      if (sum == target)
        return true;
      else if (sum > target)
        rightCounter -= 1;
      else
        leftCounter += 1;

    }

    return false;

  }

}
