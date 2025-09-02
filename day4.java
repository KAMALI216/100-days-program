//sorts uppercase and lowercase letters separately, then alternately appends them to form the final string.
import java.util.*;

public class AlternateSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        // Separate uppercase and lowercase letters
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();

        for (char ch : S.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upper.add(ch);
            } else {
                lower.add(ch);
            }
        }

        // Sort separately
        Collections.sort(upper);
        Collections.sort(lower);

        // Merge alternatively
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        boolean takeUpper = true; // Start with uppercase

        while (i < upper.size() || j < lower.size()) {
            if (takeUpper && i < upper.size()) {
                result.append(upper.get(i++));
            } else if (!takeUpper && j < lower.size()) {
                result.append(lower.get(j++));
            }
            takeUpper = !takeUpper; // Switch turn
        }

        System.out.println(result.toString());
    }
}
