

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

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;   // start at origin (0,0)

        // Go through each move in the string
        for (char move : moves.toCharArray()) {
            if (move == 'U') y++;      // move up increases y
            else if (move == 'D') y--; // move down decreases y
            else if (move == 'R') x++; // move right increases x
            else if (move == 'L') x--; // move left decreases x
        }

        // robot is back at origin only if x == 0 and y == 0
        return x == 0 && y == 0;
    }
}

class Solution {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123")); // 134
        System.out.println(addStrings("999999999999999999", "1")); // 1000000000000000000
        System.out.println(addStrings("6913259244", "71103343")); // 6984362587
    }
