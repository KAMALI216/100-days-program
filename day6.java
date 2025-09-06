//Count how many characters in stones also appear in jewels (case-sensitive). 

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        // Use a set for fast lookup of jewels
        java.util.HashSet<Character> jewelSet = new java.util.HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        // Count how many stones are jewels
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        String jewels1 = "aA";
        String stones1 = "aAAbbbb";
        System.out.println(sol.numJewelsInStones(jewels1, stones1)); // Output: 3

        // Example 2
        String jewels2 = "z";
        String stones2 = "ZZ";
        System.out.println(sol.numJewelsInStones(jewels2, stones2)); // Output: 0

        // Your Example
        String jewels3 = "12";
        String stones3 = "12312145";
        System.out.println(sol.numJewelsInStones(jewels3, stones3)); // Output: 5
    }
}


. Repeated Substring Pattern
class Solution {
    public static boolean repeatedSubstringPattern(String s) {
        String doubled=s+s;
        String trimmed=doubled.substring(1,doubled.length()-1);
        return trimmed.contains(s);
        
    }
    public static void main(String args[])
    {
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }
}

FirstUniqueCharacter

import java.util.*;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find first unique
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;  // return index of first unique char
            }
        }

