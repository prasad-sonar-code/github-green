// Time complexity: O(n), where n is the number of nodes in the tree
// Space complexity: O(h), where h is the height of the tree (worst case: O(n) for unbalanced tree)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderTraversalHelper(node.left, result);
        result.add(node.val);
        inorderTraversalHelper(node.right, result);
    }
}