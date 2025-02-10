/*
 * Problem Link: https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
 * Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
 *
 * Examples:
 * Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
 * Output: 42
 *
 * Input: root[] = [-17, 11, 4, 20, -2, 10]
 * Output: 31
 */

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

public class Solution {

  // Calculating max sums in each sub tree
  // storing it in an array for state preservation`
  int runMaxSum(Node node, int[] result) {

    if (node == null)
      return 0;

    int leftSum = Math.max(0, runMaxSum(node.left, result));
    int rightSum = Math.max(0, runMaxSum(node.right, result));

    result[0] = Math.max(result[0], leftSum + rightSum + node.data);

    return node.data + Math.max(leftSum, rightSum);

  }

  int findMaxSum(Node node) {
    int[] result = { node.data };

    runMaxSum(node, result);

    return result[0];
  }

}
