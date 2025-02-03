/*
 * Problem Link: https://www.geeksforgeeks.org/problems/height-of-binary-tree/1
 * Given a binary tree, find its height.
 *
 * The height of a tree is defined as the number of edges on the longest path
 * from the root to a leaf node. A leaf node is a node that does not have any
 * children.
 *
 * Examples:
 * Input: root[] = [12, 8, 18, 5, 11]
 * Output: 2
 *
 * Input: root[] = [1, 2, 3, 4, N, N, 5, N, N, 6, 7]
 * Output: 3
 */

class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

public class Solution {

  int height(Node node) {

    return runMaxHeight(node, 0);

  }

  // Traverse down the tree
  // till you reach the leaf
  //
  // when you reach the leaf, return the height
  int runMaxHeight(Node node, int level) {
    if (node == null)
      return level - 1;

    return Math.max(runMaxHeight(node.left, level + 1), runMaxHeight(node.right, level + 1));
  }

}
