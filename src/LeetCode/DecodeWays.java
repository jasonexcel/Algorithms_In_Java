package LeetCode;

public class DecodeWays {
	public static void main(String[] args) {
		int res = new DecodeWays().numDecodings("101");
		System.out.println(res);
	}

	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int[] ways = new int[s.length()];
		ways[0] = 1;

		int sum = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
		if (sum > 0 && sum < 27) {
			ways[1]++;
		}
		if (s.charAt(1) != '0') {
			ways[1]++;
		}

		for (int i = 2; i < s.length(); i++) {
			//
			int way = 0;
			if (s.charAt(i) != '0') {
				way = ways[i - 1];
			}
			int temp = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
			// check s.charAt(i-1) against '0' to avoid like "08"
			if (s.charAt(i - 1) != '0' && temp > 0 && temp < 27) {
				way += ways[i - 2];
			}
			ways[i] = way;

		}
		return ways[s.length() - 1];
	}

	public int numDecodings2(String s) {
		if (s == null || s.length() < 1) {
			return 0;
		}
		int len = s.length();
		int[] intArray = new int[len];
		for (int i = 0; i < len; i++) {
			intArray[i] = s.charAt(i) - '0';
		}
		int[] ways = new int[len];
		for (int j = 0; j < len; j++) {
			ways[j] = -1;
		}

		calcWays(intArray, len - 1, ways);
		return ways[len - 1];
	}

	public int calcWays(int[] arr, int endIndex, int[] ways) {
		if (endIndex == 0) {
			if (arr[0] == 0) {
				ways[0] = 0;
				return 0;
			}
			ways[0] = 1;
			return 1;
		}
		if (endIndex == 1) {
			int way = 0;
			if (arr[1] != 0 && arr[0] != 0) {
				way = 1;
			}
			if (arr[0] != 0 && arr[0] * 10 + arr[1] > 0
					&& arr[0] * 10 + arr[1] <= 26) {
				way += 1;
			}
			ways[1] = way;
			return way;
		}
		int caseA = 0;
		int caseB = 0;
		if (arr[endIndex] != 0) {
			caseA = ways[endIndex - 1] != -1 ? ways[endIndex - 1] : calcWays(
					arr, endIndex - 1, ways);
		}
		if (arr[endIndex - 1] != 0
				&& arr[endIndex - 1] * 10 + arr[endIndex] > 0
				&& arr[endIndex - 1] * 10 + arr[endIndex] <= 26) {
			caseB = ways[endIndex - 2] != -1 ? ways[endIndex - 2] : calcWays(
					arr, endIndex - 2, ways);
		}
		ways[endIndex] = caseA + caseB;
		return ways[endIndex];
	}
}
