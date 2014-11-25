/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
package LeetCode;

import java.util.List;
import java.util.ArrayList;

/**
 * @author sjia
 *
 */
public class RestoreIPAddresses {
	public static void main(String[] args){
		RestoreIPAddresses ins = new RestoreIPAddresses();
		List<String> list = ins.restoreIpAddresses("25525511135");
		System.out.println(list);
		
	}
	// my solution: backtracking
	public List<String> restoreIpAddresses(String s) {
        List<String> values = new ArrayList<String>();
        if(s == null || s.length()<4){
        	return values;
        }
        for(int i=0;i<s.length();i++){
    		int v = s.charAt(i) - '0';
    		if(v<0 || v>9){
    			return values;
    		}
    	}

        List<List<String>> results = new ArrayList<List<String>>();
        List<String> res = new ArrayList<String>();
        ipAddress(s, 0, res, results);

        for(int i=0; i<results.size(); i++){
        	String temp = new String();
        	for(String str : results.get(i)){
        		temp+=str;
        	}
        	values.add(new String(temp));
        }
        return values;
    }

    private void ipAddress(String s, int start, List<String> res, List<List<String>> results){
    	if(start==s.length() && res.size() == 4){
    		List<String> temp = new ArrayList<String>(res);
    		results.add(temp);
    		return;
    	}
    	else if(start==s.length()||res.size()>=4){
    		return;
    	}

    	for(int i=start; i<s.length(); i++){
    		String sub = s.substring(start, i+1);
    		if(validNumber(sub)){
    			if(res.size()<3){
    				sub +='.';
    				res.add(sub);
    			}
    			else{
    				res.add(sub);
    			}
    			
    			ipAddress(s, i+1, res, results);
    			res.remove(res.size()-1);

    		}
    		
    	}
    }

    private boolean validNumber(String sub){
    	if(sub==null ||sub.length()==0 || sub.length()>3){
    		return false;
    	}
    	int val = 0;
    	for(int i=0;i<sub.length();i++){
    		int v = sub.charAt(i) - '0';
    		if(sub.length()>1 && i==0 && v==0){
    			return false;
    		}
    		val +=v*Math.pow(10, sub.length()-i-1);
    	}
    	if(val>255){
    		return false;
    	}
    	return true;
    }
}
