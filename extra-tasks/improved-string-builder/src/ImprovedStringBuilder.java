public class ImprovedStringBuilder {
    private StringBuilder stringBuilder;

    public ImprovedStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    public ImprovedStringBuilder append(String str) {
        stringBuilder.append(str);
        return this;
    }

    public ImprovedStringBuilder appendLine(String str) {
        stringBuilder.append(System.lineSeparator()).append(str);
        return this;
    }

    public ImprovedStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        return this;
    }

    public ImprovedStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        return this;
    }

    public ImprovedStringBuilder replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        return this;
    }

    public int length() {
        return stringBuilder.length();
    }

    public String toString() {
        return stringBuilder.toString();
    }

    // more methods..

    public static void main(String[] args) {
        ImprovedStringBuilder sb = new ImprovedStringBuilder();
        sb.append("First line").appendLine("Second line").appendLine("Third line");
        System.out.println(sb.toString());
    }
}
