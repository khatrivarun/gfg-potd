// Problem Link: https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
// Given a Binary Search Tree (with all values unique) and two nodes n1 and n2 (n1 != n2).
// You may assume that both nodes exist in the tree. Find the Lowest Common Ancestor (LCA)
// of the given two nodes in the BST. LCA between two nodes n1 and n2 is defined as the
// lowest node that has both n1 and n2 as descendants (where we allow a node to be a
// descendant of itself).
//
// Examples:
// Input: root = [5, 4, 6, 3, N, N, 7, N, N, N, 8], n1 = 7, n2 = 8
// Output: 7
//
// Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], n1 = 8, n2 = 14
// Output: 8
//
// Input: root = [2, 1, 3], n1 = 1, n2 = 3
// Output: 2

class Node {
  int data;
  Node left, right;

  public Node(int d) {
    data = d;
    left = right = null;
  }
}

public class Solution {

  // LCA is just glorified searching for
  // those 2 nodes except its not strict
  // searching but just an idea of where
  // they might be --> LCA
  Node LCA(Node root, Node n1, Node n2) {
    if (root == null)
      return null;

    if (root.data > n1.data && root.data > n2.data)
      return LCA(root.left, n1, n2);
    if (root.data < n1.data && root.data < n2.data)
      return LCA(root.right, n1, n2);

    return root;

  }

}
