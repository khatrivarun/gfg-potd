// Problem Link: https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
// Given an array arr[] of positive integers and an integer k, Your task is to
// return k largest elements in decreasing order.
//
// Examples:
// Input: arr[] = [12, 5, 787, 1, 23], k = 2
// Output: [787, 23]
//
// Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3
// Output: [50, 30, 23]
//
// Input: arr[] = [12, 23], k = 1
// Output: [23]

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

  // Convert to list, sort in reverse order
  // and return the K sublist
  public ArrayList<Integer> kLargest(int[] arr, int k) {
    ArrayList<Integer> array = new ArrayList<>();
    for (Integer integer : arr)
      array.add(integer);

    Collections.sort(array, (one, two) -> two - one);

    return new ArrayList<Integer>(array.subList(0, k));
  }

}
