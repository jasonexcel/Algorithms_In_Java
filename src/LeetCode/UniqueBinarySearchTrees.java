/**
 * Solution:
 * DP
 * a BST can be composed by root, left subtree and right subtree.
 * if the root is fixed, every combination of unique left/right subtrees forms
 * a unique BST.
 * Let a[n] = number of unique BST's given values 1..n, then
 * a[n] = a[0] * a[n-1]     // put 1 at root, 2...n right
 *      + a[1] * a[n-2]     // put 2 at root, 1 left, 3...n right
 *      + ...
 *      + a[n-1] * a[0]     // put n at root, 1...n-1 left
 */

package LeetCode;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        //ways[n] represents the ways for n nodes
        int[] ways = new int[n+1];
        ways[0] = 1;
        //loop when root is equal from 1 to n
        for(int root=1; root<=n; root++){
        	// Java will initialize all array elements to 0 by default
            //ways[root] = 0;
            for(int left = 0; left < root; left++){
                // lways = ways for the left subtree
                int lways = ways[left];
                int rways = ways[root - left - 1];
                ways[root] += lways*rways;
            }
        }
        return ways[n];
    }
}