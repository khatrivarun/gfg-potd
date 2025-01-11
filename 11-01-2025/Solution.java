/*
 * Problem Link: https://www.geeksforgeeks.org/problems/longest-distinct-characters-in-string5848/1
 * Given a string s, find the length of the longest substring with all distinct characters.
 *
 * Examples:
 * Input: s = "geeksforgeeks"
 * Output: 7
 *
 * Input: s = "aaa"
 * Output: 1
 *
 * Input: s = "abcdefabcbb"
 * Output: 6
 */

import java.util.HashMap;

public class Solution {

  public int longestUniqueSubstr(String s) {

    int maxLength = 0;

    // To keep a count of distinct characters
    HashMap<Character, Integer> visitedCache = new HashMap<>();

    int left = 0, right = 0;

    // Idea is to loop and increase right
    // until we meet the first repeated
    // character in which case we increment
    // left and keep on deleting characters as we
    // increment left
    while (left <= right && right < s.length()) {

      Character rightCharacter = s.charAt(right);

      while (visitedCache.containsKey(rightCharacter)) {

        Character leftCharacter = s.charAt(left);
        visitedCache.remove(leftCharacter);
        left += 1;

      }

      visitedCache.put(rightCharacter, 1);
      maxLength = Math.max(maxLength, right - left + 1);
      right += 1;

    }

    return maxLength;

  }

}
