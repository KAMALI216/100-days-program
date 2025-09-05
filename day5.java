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

        return -1;  // no unique character
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));  // Output: 0
    }
}

