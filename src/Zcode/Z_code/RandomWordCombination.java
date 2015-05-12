package Zcode.Z_code;
import java.util.*;
public class RandomWordCombination {

	/**
	 * @param args
	 * 有一个String输入，其实是一个sentence, 例如“I want to buy a cup of water” 输出为 “I wnat to buy a cup of wtear”
	 *  意思是对于句子中的每个单词，例如water, 最边上两个char不能变，内部的char要随机排列重组，也就是说需要写一个random word combination的函数，
	 *  public String helper(String s), 输出随机排列出来的word
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomWordCombination ins = new RandomWordCombination();
		String s = "I am wanting to buy a cup of water";
		System.out.println(ins.randomWords(s));
	}
	public String randomWords(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
		String[] words = s.split(" ");
		if(words.length == 0) {
			return "";
		}
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<words.length; i++) {
			if(words[i].length() <= 3) {
				sb.append(words[i]);
				sb.append(' ');
			}
			else {
				sb.append(generator(words[i]));
				sb.append(' ');
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	private StringBuilder generator(String src) {
		StringBuilder strB = new StringBuilder();
		strB.append(src.charAt(0));
		char[] arr = src.substring(1, src.length()-1).toCharArray();
		randomShuffle(arr);
		for(char c : arr) {
			strB.append(c);
		}
		strB.append(src.charAt(src.length()-1));
		return strB;
	}
	
	private void randomShuffle(char[] arr) {
		if(arr == null || arr.length == 0) {
			return;
		}
		Random rd = new Random();
		for(int i=arr.length-1; i>=1; i--) {
			int index = rd.nextInt(i);
			char temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return;
	}
}
