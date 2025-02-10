// Problem Link: https://www.geeksforgeeks.org/problems/k-sum-paths/1
// Given a binary tree and an integer k, determine the number of downward-only paths
// where the sum of the node values in the path equals k. A path can start and end at
// any node within the tree but must always move downward (from parent to child).

import java.util.HashMap;

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

  public int runSumPaths(Node root, int currentSum, int k, HashMap<Integer, Integer> cumulativeSums) {
    if (root == null)
      return 0;

    int result = 0;
    currentSum += root.data;

    if (currentSum == k) {
      result += 1;
    }

    result += cumulativeSums.getOrDefault(currentSum - k, 0);

    cumulativeSums.put(currentSum, cumulativeSums.getOrDefault(currentSum, 0) + 1);

    result += runSumPaths(root.left, currentSum, k, cumulativeSums);
    result += runSumPaths(root.right, currentSum, k, cumulativeSums);

    cumulativeSums.put(currentSum, cumulativeSums.getOrDefault(currentSum, 0) - 1);

    return result;
  }

  public int sumK(Node root, int k) {
    HashMap<Integer, Integer> cumulativeSums = new HashMap<>();

    int result = runSumPaths(root, 0, k, cumulativeSums);

    return result;
  }

}
