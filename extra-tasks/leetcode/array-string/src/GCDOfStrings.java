public class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        var n1 = str1.length();
        var n2 = str2.length();

        while (n1 != n2) {
            if (n1 > n2) n1 -= n2;
            else n2 -= n1;
        }
        return str1.substring(0, n2);
    }
}