/*
 * Problem Link: https://www.geeksforgeeks.org/problems/print-anagrams-together/1
 * Given an array of strings, return all groups of strings that are anagrams.
 * The groups must be created in order of their appearance in the original array.
 *
 * Note: The final output will be in lexicographic order.
 *
 * Examples:
 * Input: arr[] = ["act", "god", "cat", "dog", "tac"]
 * Output: [["act", "cat", "tac"], ["god", "dog"]]
 *
 * Input: arr[] = ["no", "on", "is"]
 * Output: [["is"], ["no", "on"]]
 *
 * Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
 * Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  public ArrayList<ArrayList<String>> anagrams(String[] arr) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

    // Idea here is to group anagrams based on
    // their sorted strings. so if 2 words have
    // the same sorted string, they are anagrams
    // hence get grouped into one "bucket"
    for (String element : arr) {
      char[] stringArray = element.toCharArray();
      Arrays.sort(stringArray);
      String sortedString = String.valueOf(stringArray);

      ArrayList<String> anagramGroup = anagramGroups.getOrDefault(sortedString, new ArrayList<>());
      anagramGroup.add(element);

      anagramGroups.put(sortedString, anagramGroup);
    }

    // Iterate over anagram groups
    // and add it to a list
    for (String key : anagramGroups.keySet()) {
      result.add(anagramGroups.get(key));
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String[] arr1 = { "act", "god", "cat", "dog", "tac" };
    System.out.println(solution.anagrams(arr1));

    String[] arr2 = { "no", "on", "is" };
    System.out.println(solution.anagrams(arr2));

  }

}
