/**
 * https://oj.leetcode.com/problems/simplify-path/
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Shaun
 *
 */
public class SimplifyPath {
	public static void main(String[] args){
		SimplifyPath ins = new SimplifyPath();
		String test = new String("/h///.//..d/");
		System.out.println(ins.simplifyPath(test));
		System.out.println(ins.simplifyPathOthers(test));
	}
	
	public String simplifyPath(String path) {
	    if(path == null || path.length()==0)
	    {
	        return "";
	    }
	    Stack<String> s = new Stack<String>();
	    int i = 0;
	    while(i<path.length()){
	    	while(i<path.length() && path.charAt(i) == '/'){
	    		i++;
	    	}
	    	StringBuilder temp = new StringBuilder();
	    	while(i<path.length() && path.charAt(i) != '/'){
	    		temp.append(path.charAt(i));
	    		i++;
	    	}
	    	if(temp.length()>0){
		    	String str = temp.toString();
		    	if(str.equals("..")){
		    		if(!s.empty()){
			    		s.pop();
		    		}
		    	}
		    	else if(!str.equals(".")){
		    		s.push(str);
		    	}
	    	}

	    	i++;
	    }

	    //add '/'' between sub strings
	    ArrayList<String> subs = new ArrayList<String>();
	    while(!s.empty()){
	    	subs.add(s.pop());
	    }
	    StringBuilder res = new StringBuilder();
	    for(int j=subs.size()-1; j>=0; j--){
	    	res.append("/" + subs.get(j));
	    }
	    
	    if(res.length()==0)
	        return "/";
	    return res.toString();
	}
	
	public String simplifyPathOthers(String path) {
	    if(path == null || path.length()==0)
	    {
	        return "";
	    }
	    LinkedList<String> stack = new LinkedList<String>();
	    StringBuilder res = new StringBuilder();
	    int i=0;
	    
	    while(i<path.length())
	    {
	        int index = i;
	        StringBuilder temp = new StringBuilder();
	        //absolute path, skip the '/' once
	        while(i<path.length() && path.charAt(i)!='/')
	        {
	            temp.append(path.charAt(i));
	            i++;
	        }
	        //the inner while loop executed more than once, index < i
	        //
	        if(index!=i)
	        {
	            String str = temp.toString();
	            //pop one item from the stack
	            if(str.equals(".."))
	            {
	                if(!stack.isEmpty())
	                    stack.pop();
	            }
	            else if(!str.equals("."))
	            {
	                stack.push(str);
	            }
	        }
	        i++;
	    }
	    if(!stack.isEmpty())
	    {
	        String[] strs = stack.toArray(new String[stack.size()]);
	        for(int j=strs.length-1;j>=0;j--)
	        {
	          res.append("/"+strs[j]);
	        }
	    }
	    if(res.length()==0)
	        return "/";
	    return res.toString();
	}
}
