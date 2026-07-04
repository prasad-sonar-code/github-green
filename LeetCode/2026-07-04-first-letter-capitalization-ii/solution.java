import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    // Time complexity: O(n*m) where n is the number of rows and m is the average length of content_text
    // Space complexity: O(n*m) for the result table
    public String capitalize(String s) {
        StringBuilder sb = new StringBuilder();
        boolean cap = true;
        for (char c : s.toCharArray()) {
            if (c == '-') {
                sb.append(c);
                cap = true;
            } else if (Character.isLetter(c)) {
                if (cap) {
                    sb.append(Character.toUpperCase(c));
                    cap = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            } else {
                sb.append(c);
                cap = true;
            }
        }
        return sb.toString();
    }
}