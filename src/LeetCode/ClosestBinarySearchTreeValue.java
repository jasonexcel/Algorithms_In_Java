package LeetCode;

/**
 * Created by Shaun on 9/3/2016.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode sub = root.val < target ? root.right : root.left;
        if(sub == null) {
            return closest;
        }
        int subClosest = closestValue(sub, target);
        return Math.abs(closest - target) < Math.abs(subClosest - target) ? closest : subClosest;
    }
}
