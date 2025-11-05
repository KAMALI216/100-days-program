//processing the string in chunks of 2k and reversing only the first k characters of each chunk.
//Reverse String II
 	
class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();  // convert string to character array
        int n = arr.length;

        for (int i = 0; i < n; i += 2 * k) {   // process every block of 2k
            int left = i;                      // start index for reversal
            int right = Math.min(i + k - 1, n - 1); // end index (only first k chars or till end)

            // reverse characters between left and right
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        return new String(arr);   // convert array back to string
    }
}
