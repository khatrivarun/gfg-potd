// Problem Link: https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
// Serialization is to store a tree in an array so that it can be later restored and deserialization
// is reading tree back from the array. Complete the functions.
//
// serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

public class Solution {

  public ArrayList<Integer> serialize(Node root) {
    ArrayList<Integer> serializedTree = new ArrayList<>();

    Queue<Node> nodesQueue = new LinkedList<>();
    nodesQueue.add(root);

    // To serialize the tree, we can use
    // level order traversal and store
    // that in the list. For empty children
    // we can use a fallback like
    // minimum possible integer to keep track
    // of empty children
    while (!nodesQueue.isEmpty()) {
      Node currentNode = nodesQueue.poll();

      if (currentNode == null) {
        serializedTree.add(Integer.MIN_VALUE);
      } else {
        serializedTree.add(currentNode.data);

        nodesQueue.add(currentNode.left);
        nodesQueue.add(currentNode.right);
      }
    }

    return serializedTree;
  }

  // Function to deserialize a list and construct the tree.
  public Node deSerialize(ArrayList<Integer> arr) {
    if (arr.get(0) == Integer.MIN_VALUE)
      return null;

    Node rootNode = new Node(arr.get(0));
    Queue<Node> nodesQueue = new LinkedList<>();

    int nodesCounter = 1;

    // To deserialize the tree, we can use
    // level order traversal again except some
    // changes:
    //
    // We create a root node from the array's
    // first position which is generated using
    // level order traversal and push it on the queue
    //
    // Then when we are going through the traversal
    // we will build up the left and right children
    // for the polled node from the queue and add them
    // in the queue as well to build their children too
    //
    // And since for serialization, we used minimum possible
    // integer value as the fallback for null nodes
    // we will use it again here to place null nodes
    while (!nodesQueue.isEmpty()) {
      Node currentNode = nodesQueue.poll();

      if (arr.get(nodesCounter) != Integer.MIN_VALUE) {
        Node leftNode = new Node(arr.get(nodesCounter));
        currentNode.left = leftNode;

        nodesQueue.add(leftNode);
      }
      nodesCounter += 1;

      if (arr.get(nodesCounter) != Integer.MIN_VALUE) {
        Node rightNode = new Node(arr.get(nodesCounter));
        currentNode.right = rightNode;

        nodesQueue.add(rightNode);
      }
      nodesCounter += 1;
    }

    return rootNode;
  }

}
