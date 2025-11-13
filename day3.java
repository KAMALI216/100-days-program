//CHECK WHETHER THE WORD IS PRESENT IN A ROW
//KEYBOARD ROW 
import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();

            // detect which row the first character is in
            String row;
            if (row1.indexOf(lower.charAt(0)) != -1) {
                row = row1;
            } else if (row2.indexOf(lower.charAt(0)) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;
            for (char c : lower.toCharArray()) {
                if (row.indexOf(c) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(word);
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] words1 = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(sol.findWords(words1)));

        String[] words2 = {"omk"};
        System.out.println(Arrays.toString(sol.findWords(words2)));

        String[] words3 = {"adsdf","sfd"};
        System.out.println(Arrays.toString(sol.findWords(words3)));
    }
}
