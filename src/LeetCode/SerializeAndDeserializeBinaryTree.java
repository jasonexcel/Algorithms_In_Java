package LeetCode;

/**
 * Created by Shaun on 9/18/2016.
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree ins = new SerializeAndDeserializeBinaryTree();
        String str = "1 2 # # 3 # # ";
        TreeNode res = ins.deserialize(str);
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(ins.serialize(node));
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        int[] indexWrapper = {0};

        return deserializeHelper(arr, indexWrapper);
    }

    private TreeNode deserializeHelper(String[] arr, int[] indexWrapper) {
        int index = indexWrapper[0];
        if (index >= arr.length) {
            return null;
        }
        if (arr[index].equals("#")) {
            return null;
        }

        TreeNode res = new TreeNode(Integer.parseInt(arr[index]));
        indexWrapper[0]++;
        res.left = deserializeHelper(arr, indexWrapper);
        indexWrapper[0]++;
        res.right = deserializeHelper(arr, indexWrapper);
        return res;
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
