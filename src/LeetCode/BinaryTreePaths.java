package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shaun on 9/3/2016.
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        BinaryTreePaths ins = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        ins.binaryTreePaths(root);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        buildPaths(root, res, result);
        return result;
    }

    private void buildPaths(TreeNode root, List<Integer> res, List<String> result) {
        if(root.left == null && root.right == null) {
            generatePath(res, result);
            return;
        }

        if(root.left != null) {
            res.add(root.left.val);
            buildPaths(root.left, res, result);
            res.remove(res.size() - 1);
        }

        if(root.right != null) {
            res.add(root.right.val);
            buildPaths(root.right, res, result);
            res.remove(res.size() - 1);
        }

        return;
    }

    private void generatePath(List<Integer> res, List<String> result) {
        if(res.size() == 1) {
            result.add("" + res.get(0));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("" + res.get(0));
        for(int i = 1; i < res.size(); i++) {
            sb.append("->" + res.get(i));
        }
        result.add(sb.toString());
        return;
    }
}
