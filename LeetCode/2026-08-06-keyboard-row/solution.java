class Solution {
    // Time complexity: O(n*m) where n is the number of words and m is the maximum length of a word
    // Space complexity: O(n) for storing the result
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        List<String> res = new ArrayList<>();
        
        for (String word : words) {
            if (canBeTyped(word.toLowerCase(), row1) || canBeTyped(word.toLowerCase(), row2) || canBeTyped(word.toLowerCase(), row3)) {
                res.add(word);
            }
        }
        
        return res.toArray(new String[0]);
    }
    
    private boolean canBeTyped(String word, String row) {
        for (char c : word.toCharArray()) {
            if (row.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}