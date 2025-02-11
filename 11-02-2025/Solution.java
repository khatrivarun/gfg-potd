// Problem Link: https://www.geeksforgeeks.org/problems/check-for-bst/1
// Given the root of a binary tree. Check whether it is a BST or not.
// Note: We are considering that BSTs can not contain duplicate Nodes.
// A BST is defined as follows:
//
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
//
// Examples:
// Input: root = [2, 1, 3, N, N, N, 5]
// Output: true
//
// Input: root = [2, N, 7, N, 6, N, 9]
// Output: false
//
// Input: root = [10, 5, 20, N, N, 9, 25]
// Output: false

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class Solution {

  // Run inorder traversal to check for BST
  // Keep a count of previous node data
  // initially set as Minimum Possible Integer
  //
  // When we visit the node, check against the
  // previous node data and if the current node
  // is not bigger than it, return false
  // else return true. The update previous node
  // data.
  boolean inorderCheckForBst(Node node, int[] previousNodeData) {

    if (node == null)
      return true;

    if (!inorderCheckForBst(node.left, previousNodeData)) {
      return false;
    }

    if (previousNodeData[0] >= node.data) {
      return false;
    }

    previousNodeData[0] = node.data;

    return inorderCheckForBst(node.right, previousNodeData);

  }

  boolean isBST(Node root) {
    int[] previousNodeData = { Integer.MIN_VALUE };
    return inorderCheckForBst(root, previousNodeData);
  }

}
