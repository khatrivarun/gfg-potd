// Problem Link: https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
// Given the root of a Binary search tree(BST), where exactly two nodes were swapped
// by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not
// change the structure of the tree.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

  void inorderTraversal(Node node, List<Node> traversal) {

    if (node == null)
      return;

    inorderTraversal(node.left, traversal);
    traversal.add(node);
    inorderTraversal(node.right, traversal);

  }

  void correctBST(Node root) {

    List<Node> traversal = new ArrayList<>();
    List<Node> offendingNodes = new ArrayList<>();

    inorderTraversal(root, traversal);
    ArrayList<Node> sortedTraversal = new ArrayList<>(traversal);
    Collections.sort(sortedTraversal, (nodeOne, nodeTwo) -> nodeOne.data - nodeTwo.data);

    for (int i = 0; i < traversal.size(); i++) {
      Node currentNode = traversal.get(i);
      Node currentSortedNode = sortedTraversal.get(i);

      if (currentNode != currentSortedNode)
        offendingNodes.add(currentNode);
    }

    Node swapOne = offendingNodes.get(0);
    Node swapTwo = offendingNodes.get(1);

    int swap = swapOne.data;
    swapOne.data = swapTwo.data;
    swapTwo.data = swap;

  }

}
