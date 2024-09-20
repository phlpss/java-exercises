import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

        char[] sCharArray = s.toCharArray();
        int left = 0;
        int right = sCharArray.length - 1;

        while (left < right) {
            // Move left pointer until a vowel is found
            while (left < right && !vowels.contains(sCharArray[left])) {
                left++;
            }
            // Move right pointer until a vowel is found
            while (left < right && !vowels.contains(sCharArray[right])) {
                right--;
            }
            // Swap the vowels at left and right
            char temp = sCharArray[left];
            sCharArray[left] = sCharArray[right];
            sCharArray[right] = temp;

            // Move both pointers
            left++;
            right--;
        }

        return new String(sCharArray);
    }
}
