package basicAlgorithms;

import java.util.*;

public class AlgoTest {

	/**
	 * @param args
	 */

	public enum Suit {
		CLUBS, HEARTS, SPADES, DIAMONDS
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

//
		long a = (long) 255 <<24;
		long b = 255 <<24 & 0xFF000000;
		System.out.println("a = " + a);
		System.out.println("b = " + b);


//		Scanner sc = new Scanner(System.in);
///*		//String str = sc.nextLine();
//		String str2 = sc.next();
//		System.out.println(str2);*/
//		
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int t = 0; t < n; t++) {
//            arr[t] = sc.nextInt();
//            System.out.println();
//        }
//        for(int elem : arr) {
//        	System.out.print(elem + ", ");
//        }

		int test = (int) Math.floor(-7 / 4.);
		System.out.println("-2.5=" + Math.floor(-2.5));
		System.out.println("-7/4=" + test);
		Suit s = null;
		s = Suit.HEARTS;
		switch (s) {
			case HEARTS:
				System.out.println("h");
				break;
			case CLUBS: {
				System.out.println("c");
				System.out.println("h");
				break;
			}

			default:
				System.out.println("h");
		}

		for (Suit st : Suit.values()) {
			System.out.println(st);
		}
		AlgoTest ins = new AlgoTest();
		String doc = "the      quick brown '#fox'!  I jumps over the lazy dog";
		ins.wordCountII(doc);

		System.out.println(ins.findTheDifference("aabc", "aabac"));
		System.console();

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(3);
		stack.peek();
		stack.pop();


	}


	// the quick brown fox jumps over the lazy dog
	// quick: 1, brown: 1, the: 2
	// input: String doc
	// output: HashMap<String, Integer> res

	// doc is null
	// the      quick brown 'fox'!  I jumps over the lazy dog
	// lazy!!!***** dog 
	// I am proficient with ASP.NET 
	public Map<String, Integer> wordCount(String doc) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		if (doc == null || doc.length() == 0) {
			return res;
		}
		StringBuilder word = new StringBuilder();
		doc = doc.trim();
		for (int index = 0; index < doc.length(); index++) {
			char c = doc.charAt(index);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || (0 <= c && c <= 9)) {
				word.append(c);
				continue;
			} else {
				if (word.length() > 0) {
					String curStr = word.toString();
					if (res.containsKey(curStr)) {
						res.put(curStr, res.get(curStr) + 1);
					} else {
						res.put(curStr, 1);
					}
					word = new StringBuilder();
				}

			}
		}
		return res;
	}

	// the quick brown fox jumps over the lazy dog
	// quick: 1, brown: 1, the: 2
	// input: String doc
	// output: HashMap<String, Integer> res

	public AlgoTest() {
	}

	// doc is null
	// the      quick brown 'fox'!  I jumps over the lazy dog
	// 
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);

	}

	public Map<String, Integer> wordCountII(String doc) {
		Map<String, Integer> res = new HashMap<String, Integer>();
		if (doc == null || doc.length() == 0) {
			return res;
		}

		doc = doc.trim();
		String[] arr = doc.split("\\s+");

		for (int index = 0; index < arr.length; index++) {
			String curStr = trimPrePostSpecialAndToLower(arr[index]);
			if (curStr == null || curStr.length() == 0) {
				continue;
			}

			if (res.containsKey(curStr)) {
				res.put(curStr, res.get(curStr) + 1);
			} else {
				res.put(curStr, 1);
			}
		}
		return res;
	}

	private String trimPrePostSpecialAndToLower(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		int start;
		for (start = 0; start < str.length(); start++) {
			char c = str.charAt(start);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
				break;
			}
		}
		int end;

		for (end = str.length() - 1; end >= start; end--) {
			char c = str.charAt(end);
			if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
				break;
			}
		}

		if (start <= end) {
			return str.substring(start, end + 1).toLowerCase();
		} else {
			return "";
		}

		//System.out.println("y");
	}


	public ArrayList<Integer> getRow(int rowIndex) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (rowIndex < 0) {
			return null;
		}
		ArrayList<Integer> rowList = new ArrayList<Integer>();
		if (rowIndex == 0) {
			rowList.add(1);
		} else {
			for (int i = 0; i <= rowIndex; i++) {
				long comVal = 1;
				if (i == 0) {
					comVal = 1;
				} else if (i <= rowIndex / 2) {
					comVal = calcFactRange(rowIndex - i + 1, rowIndex) / calcFactRange(1, i);
				} else {
					comVal = rowList.get(rowIndex - i);
				}
				rowList.add((int) comVal);
			}
		}
		return rowList;
	}

	private long calcFactRange(int low, int high) {
		long val = 1;
		while (low <= high) {
			val *= low;
			low++;
		}
		if (val == 1) {

		}
		if (val == 1) {

		}
		return val;
	}


	public char findTheDifference(String s, String t) {
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

		for(int i = 0; i<s.length(); i++) {
			if(chars.containsKey(s.charAt(i))) {
				chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
			} else {
				chars.put(s.charAt(i), 1);
			}
		}
		for(int i=0; i<t.length(); i++) {
			if(chars.containsKey(t.charAt(i)) && chars.get(t.charAt(i)) > 1) {
				chars.put(t.charAt(i), chars.get(t.charAt(i)) - 1);
			} else if(chars.containsKey(t.charAt(i))){
				chars.remove(t.charAt(i));
			} else {
				return t.charAt(i);
			}

		}
		return t.charAt(0);
	}
}
