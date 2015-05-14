package Zcode.Z_code;

/**
 * http://blog.csdn.net/zmazon/article/details/8227610
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author sjia
 *
 */
class TrieNode{//结点类
	
	private static final int  NUMBER = 26;
	private char _value;
	private boolean _isWord;//从根节点到这个节点存不存在一个单词 
	TrieNode[] _children;
	public TrieNode(char c) {
		this.setValue(c);
		this._children = new TrieNode[NUMBER];
	}
	public char getValue() {
		return _value;
	}
	public void setValue(char _value) {
		this._value = _value;
	}
	public boolean isWord() {
		return _isWord;
	}
	// !!!
	public void setIsWord(boolean _isWord) {
		this._isWord = _isWord;
	}	
}

public class Tries {	
	static String[] _words = {"amy","ann","emma","rob","roger", "robc", "thinki"};//待插入单词

	private boolean searchWord(TrieNode _root, String _word) {	
		if(null == _root || null == _word || "".equals(_word))
			return false;
		char[] cs = _word.toCharArray();//将字符串转化为字符数组
		for(int i = 0; i < cs.length; i++){			
			int index;
			if(cs[i] >= 'A' && cs[i] <= 'Z'){
				index = cs[i]-'A';
			}
			else if(cs[i] >= 'a' && cs[i] <= 'z') 
				index = cs[i] - 'a';
			else
				return false;
			
			TrieNode child_node = _root._children[index];
			if(child_node == null) {
				return false;
			}
			else {
				_root = child_node;
			}				
		}
		
		return _root.isWord();
	}

	private void insertIntoTree(TrieNode _root, String _word) {//插入一个单词		
		if(null == _root || null == _word || "".equals(_word))
			return;
		char[] cs = _word.toCharArray();//将字符串转化为字符数组
		for(int i = 0; i < cs.length; i++){			
			int index;//对应的索引值
			if(cs[i] >= 'A' && cs[i] <= 'Z'){
				index = cs[i]-'A';
			}
			else if(cs[i] >= 'a' && cs[i] <= 'z') 
				index = cs[i] - 'a';
			else
				return;
			// !!!
			TrieNode child_node = _root._children[index];			
			if(null == child_node){//如果没找到
				TrieNode new_node = new TrieNode(cs[i]);//创建新节点
				//如果遍历到该单词最后一个字符
				// !!!
				if(i == cs.length-1) {
					new_node.setIsWord(true);//把该单词存在树中
				}					
				_root._children[index] = new_node;//连接该节点
				_root = new_node;				
			}
			else {
				_root = child_node;//更新树根	
			}								
		}
	}

	private void printTree(TrieNode _root, List<Character> list) {		
		if(_root == null) {
			return;
		}
		if(_root.isWord()){//如果根节点到此节点构成一个单词则输出
			for(char c : list) {
				System.out.print(c);
			}			
			System.out.println();
		}		
		for(TrieNode node : _root._children){//遍历树根孩子节点
			if(node != null){//回溯法遍历该树
				list.add(node.getValue());
				//_word[index++] = node.getValue();
				printTree(node, list);
				//_word[index] = ' ';
				list.remove(list.size()-1);				
			}
		}			
	}
	public static void main(String[] args){
		Tries _tree = new Tries();//创建一棵树
		TrieNode _root = new TrieNode(' ');//创建根节点
		for(String word : _words)//插入单词
			_tree.insertIntoTree(_root,word);
		List<Character> list = new ArrayList<Character>();
		_tree.printTree(_root, list);//打印树中单词
		boolean status = _tree.searchWord(_root,"roba");//查询树中是否存在某单词
		System.out.println(status);
	}
}
