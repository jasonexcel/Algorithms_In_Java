package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import RealInterviewQuestion.UneatenLeaves;

public class Solution {

	int leaves;
	List<Integer> stepList;	

	public static void main(String[] args) {
		int N = 10;
		int[] A = {2, 4, 5};
		int count = countUneatenLeaves(N, A);
		System.out.println(count);
		System.console();
	}
	
	static int countUneatenLeaves(int N, int[] A) {
		Solution ins = new Solution();
		ins.leaves = N;
		Arrays.sort(A);

		ins.stepList = ins.removeSimilar(A);

		return ins.leftLeaves();
	}
	
	private List<Integer> removeSimilar(int[] arr) {
		List<Integer> res = new ArrayList<Integer>();
		if(arr == null || arr.length == 0) {
			return res;
		}
		res.add(arr[0]);
		for(int i=1; i<arr.length; i++) {
			int j;
			for(j=0; j<res.size(); j++) {
				int div = res.get(j);
				if(div != 0 && arr[i]%div == 0) {
					break;
				}
			}
			if(j == res.size()) {
				res.add(arr[i]);
			}
		}
		return res;
	}
	public int leftLeaves() {
		int len = stepList.size();
		int eatenLeaves = 0;
		for(int sel=1; sel<=len; sel++) {
			int curTotalIntersections = selWiseIntersections(sel);
			
			if(curTotalIntersections == 0) {
				//no intersections forward, break the loop
				break;
			}
			//inclusion-exclusion principle
			if(sel%2 == 1) {				
				eatenLeaves += curTotalIntersections;
			}
			else {
				eatenLeaves -= curTotalIntersections;
			}
		}
		return Math.max(leaves - eatenLeaves, 0);
	}
	
	private int selWiseIntersections(int sel) {
		int[] sum = new int[1];
		ArrayList<Integer> res = new ArrayList<Integer>();
		combineHelp(sum, res, 0, sel);
		return sum[0];
	}
	private void combineHelp(int[] sum, ArrayList<Integer> res, int index, int sel){
    	if(res.size() == sel){
    		int lcm = leastCommonMultiple(res);
    		sum[0] += leaves / lcm;
    		return;
    	}
    	for(int i=index; i<stepList.size(); i++){
			res.add(stepList.get(i));
    		combineHelp(sum, res, i+1, sel);
    		res.remove(res.size()-1);
    	}    
    	return;		
    }
	
	private int leastCommonMultiple(List<Integer> list) {
		int res = list.get(0);
		for(int i=1; i<list.size(); i++) {
			res = leastCommonMultipleOfTwo(res, list.get(i));
		}
		return res;
	}
	
	private int leastCommonMultipleOfTwo(int numberA, int numberB) {
		int gcd = greatestCommonDivisor(numberA, numberB);
		return numberA/gcd*numberB;
	}
	
	private int greatestCommonDivisor(int numberA, int numberB) {
		if(numberA < 1 || numberB < 1) {
			return 1;
		}
		int temp = Math.max(numberA,  numberB);
		numberB = Math.min(numberA, numberB);
		numberA = temp;
		while(numberB != 0) {
			temp = numberB;
			numberB = numberA%numberB;
			numberA = temp;
		}
		return numberA;
	}

}
