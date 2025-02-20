// Problem Link: https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
// Given a data stream arr[] where integers are read sequentially, the task is to determine
// the median of the elements encountered so far after each new integer is read.
//
// Examples:
// Input:  arr[] = [5, 15, 1, 3, 2, 8]
// Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]
//
// Input: arr[] = [2, 2, 2, 2]
// Output: [2.0, 2.0, 2.0, 2.0]

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

  // Here the approach is to maintain 2 heaps
  // one max (handling the left half of the broader zone)
  // and min (handling the right half of the broader zone)
  // and our goal will be to keep them balanced (atmost
  // one element more in length)
  //
  // As the stream flows, we add it to the minheap,
  // remove top of minheap and add it to maxheap
  // for balancing and if maxheap is more than
  // minheap, rebalance it out
  //
  // then the median is between the top of the heaps
  public ArrayList<Double> getMedian(int[] arr) {
    ArrayList<Double> result = new ArrayList<>();

    PriorityQueue<Integer> leftSideMaxHeap = new PriorityQueue<>((one, two) -> two - one);
    PriorityQueue<Integer> rightSideMinHeap = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      leftSideMaxHeap.add(arr[i]);

      rightSideMinHeap.add(leftSideMaxHeap.poll());

      if (leftSideMaxHeap.size() < rightSideMinHeap.size())
        leftSideMaxHeap.add(rightSideMinHeap.poll());

      if (leftSideMaxHeap.size() == rightSideMinHeap.size())
        result.add((leftSideMaxHeap.peek() + rightSideMinHeap.peek()) / 2.0);
      else
        result.add((double) leftSideMaxHeap.peek());
    }

    return result;
  }

}
