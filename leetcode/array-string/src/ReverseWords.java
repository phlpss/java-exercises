public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        var left = 0;
        var right = words.length - 1;

        while(left < right) {
            var temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        return String.join(" ", words);
    }
}