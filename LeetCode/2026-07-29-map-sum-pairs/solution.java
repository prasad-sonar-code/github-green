// Time complexity: O(1) for insert, O(n) for sum where n is the number of keys with the given prefix
// Space complexity: O(n) where n is the number of keys
class MapSum {
    private class TrieNode {
        int val;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;
    private Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return 0;
            }
            node = node.children[c - 'a'];
        }
        return node.val;
    }
}