public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        var result = new StringBuilder();
        var i = 0;
        var j = 0;
        var length1 = word1.length();
        var length2 = word2.length();

        while(i < length1 || j < length2) {
            if(i < length1) {
                result.append(word1.charAt(i));
                i++;
            }
            if(j < length2) {
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
}
